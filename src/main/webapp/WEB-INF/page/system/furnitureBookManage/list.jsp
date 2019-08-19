<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
	<jsp:include page="/WEB-INF/inc/common.jsp"></jsp:include>
	<title>用户管理</title>
</head>
<body>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/js/jquery-3.3.1.min.js"></script>--%>
<script>
	function confirmAct(){
		if(confirm('确定要执行此操作吗?'))
		{

			return true;
		}
		return false;
	}
    $(document).on("click",".borrowOn,.borrowOff",function(){
        var obj = $(this);
        var fbid = obj.attr("fbid");
        var bname = obj.attr("bname");
        var borrowSwitch = obj.attr("borrowSwitch");
        if("on" === borrowSwitch){
            borrowSwitchAjax(fbid,bname,obj);
        }else if("off" === borrowSwitch){
            if(confirm("你确定归还吗？")){
                borrowSwitchAjax(fbid,bname,obj);
            }
        }
    });

    var borrowSwitchAjax = function(fbId,bname,obj){
        $.ajax({
            type:"PUT",
            url:fbId+"/"+bname+"/borrow.do",
            dataType:"json",
            success:function(data){
                /*
                 * resultMsg:success/failed
                 * errorCode:exception000001
                 * appId:appId
                 * errorCode:param000001
                 */

                /*alert(fbId);*/
                var data = eval("("+data+")");
				/*alert(data.resultMsg);*/
                if(data.errorCode === '0'){
                    if(data.resultMsg === "success") {//操作成功
                        if ("on" === obj.attr("borrowSwitch")) {
                            $("#borrowStatus" + obj.attr("fbid")).html("已领用");
                            obj.className = "borrowOff";
                            obj.html("<input class=\"btn btn-success radius\" type=\"button\" value=\"归还\">");
                            obj.attr("borrowSwitch", "off");
                            $("#borrowStatus" + obj.attr("fbid")).css({
                                'background': 'green',
                                'color': '#fff',
                                'padding': '3px',
                                'border-radius': '3px'
                            });
                            $("#borrowStatus" + obj.attr("fbid")).hide();
                            $("#borrowStatus" + obj.attr("fbid")).slideDown(300);
                        } else if ("off" === obj.attr("borrowSwitch")) {
                            $("#borrowStatus" + obj.attr("fbid")).html("已归还");
                            obj.className = "borrowOn";
                            obj.html("<input class=\"btn btn-success radius\" type=\"button\" value=\"领用\">");
                            obj.attr("borrowSwitch", "on");
                            $("#borrowStatus" + obj.attr("fbid")).css({
                                'background': 'red',
                                'color': '#fff',
                                'padding': '3px',
                                'border-radius': '3px'
                            });
                            $("#borrowStatus" + obj.attr("fbid")).hide();
                            $("#borrowStatus" + obj.attr("fbid")).slideDown(300);
                        }
                    }else if (data.resultMsg === "param000001") {
                    	alert("传参错误！");
					}
                }
            },
            error:function(data){
               alert("error");
            }
        });
    };

</script>
<div class="wap-container">
	<article class="Hui-admin-content clearfix">
		<div class="panel">
			<form class="search-form" action="${pageContext.request.contextPath}/system/furnitureBookManage/list.do">
				<div class="panel-body">
					<div class="row clearfix">
						<div class="col-xs-12 col-sm-6 col-md-4">
							<div class="row clearfix mb-10">
								<span class="col-xs-2 form-item-label">名称:</span> <span class="col-xs-3 form-item-control"> <input type="text" name="fbName"   value="${requestScope.fbName }" placeholder="" class="input-text" />
								</span>
								<span class="col-xs-3 form-item-label">领用状态:</span>
								<span class="col-xs-4 form-item-control">
										<select id="borrowStatus" name="borrowStatus" class="input-text">
											<%--下面没有value="${organization.id}"会报类型错误--%>
											<option value="${fbDictionary.fbKey}">--请选择--</option>
											<c:if test="${requestScope.BS ne null }">
												<c:forEach items="${requestScope.BS}" var="fbDictionary">
													<option value="${fbDictionary.fbKey}" ${requestScope.borrowStatus eq fbDictionary.fbKey?"selected":"" }>${fbDictionary.fbValue}</option>
												</c:forEach>
											</c:if>
										</select>
									</span>
							</div>
						</div>
						<input type="hidden" name="method" value="">
						<div class="col-xs-12 col-sm-6 col-md-4">
							<div class="row clearfix">
								<span class="col-xs-3 form-item-label">损坏状态:</span>
								<span class="col-xs-4 form-item-control">
										<select id="damageStatus" name="damageStatus" class="input-text">
											<%--下面没有value="${organization.id}"会报类型错误--%>
											<option value="${fbDictionary.fbKey}">--请选择--</option>
											<c:if test="${requestScope.DS ne null }">
												<c:forEach items="${requestScope.DS}" var="fbDictionary">
													<option value="${fbDictionary.fbKey}" ${requestScope.damageStatus eq fbDictionary.fbKey?"selected":"" }>${fbDictionary.fbValue}</option>
												</c:forEach>
											</c:if>
										</select>
									</span>
								<span class="col-xs-3 form-item-control">
										<button name="" id="search-submit" class="btn btn-success radius" type="submit">
											<i class="Hui-iconfont">&#xe665;</i> 搜索
										</button>
									</span>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="panel mt-20">
			<div class="panel-body">
				<div class="clearfix">
						<span class="f-l">
						<a href="javascript:;" onclick="batchdel('${pageContext.request.contextPath}/system/furnitureBookManage/batchDelete.do')" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
						<a href="javascript:;" onclick="insert('登记入库','${pageContext.request.contextPath}/system/furnitureBookManage/toInsert.do','800','500')" class="btn btn-primary radius"> <i class="Hui-iconfont">&#xe600;</i> 登记入库
						</a>
						</span> <span class="f-r">共有数据：<strong>${requestScope.page.total }</strong> 条
						</span>
				</div>
				<div class="mt-20 clearfix">
					<table id="data-table-list" class="table table-border table-bordered table-bg table-hover table-sort">
						<thead>
						<tr class="text-c">
							<th width="25"><input type="checkbox" name="" value=""></th>
							<th>产品名称</th>
							<th>规格</th>
							<th>登记人</th>
							<th>报修状态</th>
							<th>领用状态</th>
							<%--<th>领用状态</th>--%>
							<th>领用人</th>
							<th>损坏状态</th>
							<th>维修状态</th>
							<th>流水号</th>
							<th>单据号</th>
							<th>操作</th>
						</tr>
						</thead>
						<tbody class="getData-list" data-currPage='1'>
						<c:forEach items="${requestScope.page.records }" var="record" varStatus="borrowStatus">
							<tr class="text-c">
								<td><input type="checkbox" value="${record.id }" class="checkbox-box"></td>
								<td>${record.fbName }</td>
								<td>${record.fbSpec }</td>
								<td>${record.register }</td>
								<td>${record.rsName }</td>
                                <td><span id="borrowStatus${record.id }">${record.bsName }</span></td>
<%--								<td>${record.borrowStatus }</td>--%>
								<td>${record.borrowBy }</td>
								<td>${record.dsName }</td>
								<td>${record.msName }</td>
								<td>${record.pipelineNumber }</td>
								<td>${record.borrowNumber }</td>
                                <td>
                                    <span class="dropDown"> <a class="dropDown_A" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"><input class="btn radius btn-warning" type="button" value="点击操作"></a>
                                        <ul class="dropDown-menu menu radius box-shadow">
                                            <li>
                                                <c:choose>
                                                    <c:when test="${record.damageStatus == 2 && record.repairStatus == 1}">
                                                        <a href="${pageContext.request.contextPath}/system/furnitureBookManage/updateRepairName.do?&id=${record.id }"><input class="btn btn-primary radius"  type="button" value="报修"></a>
                                                        <%--<a title="报修" href="${pageContext.request.contextPath}/system/furnitureBookManage/updateRepairName.do?&id=${record.id }"  class="ml-5" style="text-decoration: none"><i class="Hui-iconfont">报修</i></a>
                                                    --%></c:when>
                                                </c:choose>
                                            </li>
                                            <li>
                                                <c:choose>
                                                    <c:when test="${record.borrowStatus == 1 && record.maintainStatus != 5}">
                                                        <a class="borrowOn" borrowSwitch="on" bname=${sessionScope.user.name } fbid=${record.id }><input class="btn btn-primary radius"  type="button" value="领用"></a>
                                                       <%-- <a class="borrowOn" borrowSwitch="on" bname=${sessionScope.user.name } fbid=${record.id }><i class="Hui-iconfont">领用</i></a>--%>
                                                    </c:when>
                                                    <c:when test="${record.borrowStatus == 2}">
                                                        <a class="borrowOff" borrowSwitch="off" fbid=${record.id }><input class="btn btn-primary radius"  type="button" value="归还"></a>
                                                        <%--<a class="borrowOff" borrowSwitch="off" fbid=${record.id } ><i class="Hui-iconfont">归还</i></a>--%>
                                                    </c:when>

                                                </c:choose>
                                            </li>
                                            <li>
                                                <c:choose>
                                                    <c:when test="${record.maintainStatus == 2}">
                                                        <a href="${pageContext.request.contextPath}/system/furnitureBookManage/updateMaintainName.do?&id=${record.id }"><input class="btn btn-primary radius"  type="button" value="维修"></a>
                                                        <%--<a title="维修" href="${pageContext.request.contextPath}/system/furnitureBookManage/updateMaintainName.do?&id=${record.id }"  class="ml-5" style="text-decoration: none"><i class="Hui-iconfont">维修</i></a>--%>
                                                    </c:when>
                                                    <c:when test="${record.maintainStatus == 4 && record.damageStatus == 2}">
                                                        <a href="${pageContext.request.contextPath}/system/furnitureBookManage/updateById.do?&id=${record.id }" onclick="return confirmAct()"><input class="btn btn-primary radius"  type="button" value="报废"></a>
                                                        <%--<a class="baofei" title="报废" href="${pageContext.request.contextPath}/system/furnitureBookManage/delectById.do?&id=${record.id }" onclick="return confirmAct()" class="ml-5" style="text-decoration: none"><i class="Hui-iconfont">报废</i></a>
                                                   --%> </c:when>
                                                </c:choose>
                                            </li>
                                            <li>
                                                 <a title="编辑" href="javascript:;" onclick="update('编辑','${pageContext.request.contextPath}/system/furnitureBookManage/toUpdate.do?&id=${record.id }','1','800','500')" class="ml-5" style="text-decoration: none"><input class="btn btn-primary radius"  type="button" value="编辑"></a>
                                                <%--<a title="编辑" href="javascript:;" onclick="update('编辑','${pageContext.request.contextPath}/system/furnitureBookManage/toUpdate.do?&id=${record.id }','1','800','500')" class="ml-5" style="text-decoration: none"><i class="Hui-iconfont">编辑</i></a>
                                            --%></li>
                                            <li>
                                                <a title="删除" href="javascript:;" onclick="del(this,'${pageContext.request.contextPath}/system/furnitureBookManage/delete.do?&id=${record.id}')" class="ml-5" style="text-decoration: none"><input class="btn btn-primary radius"  type="button" value="删除"></a>
                                               <%-- <a title="删除" href="javascript:;" onclick="del(this,'${pageContext.request.contextPath}/system/furnitureBookManage/delete.do?&id=${record.id}')" class="ml-5" style="text-decoration: none"><i class="Hui-iconfont">删除</i></a></td>
                                           --%> </li>
                                        </ul>
                                    </span>
                                </td>
								<%--<td class="f-14 td-manage">
									<c:choose>
										<c:when test="${record.borrowStatus == 1}">
											<a class="borrowOn" borrowSwitch="on" bname=${sessionScope.user.name } fbid=${record.id }><i class="Hui-iconfont">&#xe600;</i></a>
										</c:when>
										<c:when test="${record.borrowStatus == 2}">
                                            <a class="borrowOff" borrowSwitch="off" fbid=${record.id } ><i class="Hui-iconfont">&#xe6a1;</i></a>
                                        </c:when>

									</c:choose>
									<c:choose>
										<c:when test="${record.damageStatus == 2}">
											<a title="报修" href="${pageContext.request.contextPath}/system/furnitureBookManage/updateRepairName.do?&id=${record.id }"  class="ml-5" style="text-decoration: none"><i class="Hui-iconfont">报修</i></a>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${record.maintainStatus == 2}">
											<a title="维修" href="${pageContext.request.contextPath}/system/furnitureBookManage/updateMaintainName.do?&id=${record.id }"  class="ml-5" style="text-decoration: none"><i class="Hui-iconfont">维修</i></a>
										</c:when>
										<c:when test="${record.maintainStatus == 4}">
											<a class="baofei" title="报废" href="${pageContext.request.contextPath}/system/furnitureBookManage/delectById.do?&id=${record.id }" onclick="return confirmAct()" class="ml-5" style="text-decoration: none"><i class="Hui-iconfont">报废</i></a>
										</c:when>
									</c:choose>
									<a title="编辑" href="javascript:;" onclick="update('编辑','${pageContext.request.contextPath}/system/furnitureBookManage/toUpdate.do?&id=${record.id }','1','800','500')" class="ml-5" style="text-decoration: none"><i class="Hui-iconfont">&#xe6df;</i></a>
									<a title="删除" href="javascript:;" onclick="del(this,'${pageContext.request.contextPath}/system/furnitureBookManage/delete.do?&id=${record.id}')" class="ml-5" style="text-decoration: none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
								</td>--%>
							</tr>
						</c:forEach>

						</tbody>
					</table>
				</div>
				<div id="laypage" class="text-c"></div>
			</div>
		</div>
	</article>
</div>
<%--<script src="${pageContext.request.contextPath }/static/localjs/fbmanage.js"></script>--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/js/main.js"></script>
<!--/请在上方写此页面业务相关的脚本-->
<script type="text/javascript">
	//渲染分页
	laypage({
		cont : 'laypage',
		pages : ${requestScope.page.pages },
		curr :  ${requestScope.page.pageNum },
		jump : function(e, first) { //触发分页后的回调
			if (!first) { //一定要加此判断，否则初始时会无限刷新
				location.href = getFormUrl($(".search-form"))+"&pageNum="+e.curr;
			}
		}
	});
	function insert(title, url, w, h) {
		//hui自己封装的方法
		//里面底层实现就是layer.open()
		layer_show(title, url, w, h);
	}
	function update(title, url, id, w, h) {
		layer_show(title, url, w, h);
	}
	function del(obj, url) {
		layer.confirm('确认要删除吗？', function(index) {
			$.ajax({
				type : 'POST',
				url : url,
				dataType : 'json',
				success : function(data) {
					commonreuslt(data);
				}
			});
		});
	}

	function batchdel(url) {
		if ($(".checkbox-box:checked")) {
			if ($(".checkbox-box:checked").length > 0) {
				var pars = '';
				$(".checkbox-box:checked").each(function(i, v) {
					pars += '&ids=' + $(v).val();
				});
				layer.confirm('确认要删除吗？', function(index) {
					$.ajax({
						type : 'POST',
						url : url,
						data : pars,
						success : function(data) {
							commonreuslt(data);
						}
					});
				});
			} else {
				layer.msg("请选择你要删除的内容", {
					icon : 5,
					time : 1000
				});
			}
		}

	}
</script>
</body>
</html>