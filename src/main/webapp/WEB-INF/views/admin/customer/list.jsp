<%--<%@ page import="com.laptrinhjavaweb.dto.DistrictDTO" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="customerListUrl" value="/admin/customer-list"></c:url>

<html>
<head>
    <title>Danh sách khách hàng</title>
</head>
<body>

<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="<c:url value="/admin/home"/> ">Trang chủ</a>
                </li>
                <li class="active">Danh sách khách hàng</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">
                <div class="widget-box">
                    <div class="widget-header">
                        <h4 class="widget-title">Tìm kiếm khách hàng</h4>
                        <div class="widget-toolbar">
                            <a href="#" data-action="collapse">
                                <i class="ace-icon fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
                    <div class="widget-body">
                        <div class="widget-main">
                            <form:form modelAttribute="customerSearch" action="${customerListUrl}" id="listForm" method="GET">
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-xs-12 ">
                                            <!-- PAGE CONTENT BEGIN -->
                                           <div class="col-md-4" >
                                                <label><b>Tên khách hàng</b></label>
                                                <form:input path="fullName" cssClass="form-control" />
                                            </div>

                                            <div class="col-md-4">
                                                <label><b>Di động</b></label>
                                                <form:input path="phone" cssClass="form-control"/>
                                            </div>

                                            <div class="col-md-4">
                                                <label><b>Email</b></label>
                                                <form:input path="email" cssClass="form-control"/>
                                            </div>
                                            <!-- PAGE CONTENT ENDS -->
                                        </div><!-- /.col -->
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-xs-12 ">
                                            <div class="col-md-3">
                                                <label><b>Nhân Viên Phụ trách</b></label>
                                                <form:select path="staffId" class="form-control">
                                                    <option selected value="">---Chọn nhân viên phụ trách---</option>
                                                    <c:forEach var="item" items="${staffs}">
                                                        <form:option value="${item.id}">${item.fullName}</form:option>
                                                    </c:forEach>
                                                </form:select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                </br>
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="col-md-3">
                                            <button class="btn btn-primary" id="btnSearch">Tìm Kiếm</button>
                                        </div>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div><!-- /.row -->
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <div class="pull-right">
                        <button id="xoaBuilding" class="btn btn-white btn-warning btn-bold" data-toggle="tooltip,modal"
                                title="Xoá Toà Nhà" onclick="warningDelete()">
                            <i class="fa fa-trash-o" aria-hidden="true"></i>
                        </button>
                    </div>

                    <div class="pull-right">
                        <button class="btn btn-white btn-info btn-bold" data-toggle="tooltip"
                                title="Thêm khách hàng"
                                onclick="window.location.href='<c:url value="/admin/customer-edit"/>'">
                            <i class="fa fa-plus-circle" aria-hidden="true"></i>
                        </button>
                    </div>
                </div>
            </div>
            <br/>

            <!-- Modal Xac Nhan xoa-->
            <div class="modal fade" id="myModal" role="dialog" >
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Xác nhận xoá</h4>
                        </div>
                        <div class="modal-body">
                            <p>Bạn có muốn xoá tòa nhà đã chọn ?</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" id="btnXoa" class="btn btn-default">Xoá</button>
                        </div>
                    </div>

                </div>
            </div>

            <%--paging--%>
            <div class="row">
                <div class="col-xs-12">
                    <div class="table-responsive">
                        <display:table name="customerSearch.listResult" cellspacing="0" cellpadding="0"
                                       requestURI="${customerListUrl}" partialList="true" sort="external"
                                       size="${customerSearch.totalItems}" defaultsort="2" defaultorder="ascending"
                                       id="tableList" pagesize="${customerSearch.maxPageItems}"
                                       export="false"
                                       class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                       style="margin: 3em 0 1.5em;">
                            <display:column title="<fieldset class='form-group'>
												        <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>" class="center select-cell"
                                            headerClass="center select-cell">
                                <fieldset>
                                    <input type="checkbox" name="checkList" value="${tableList.id}"
                                           id="checkbox_${tableList.id}" class="check-box-element"/>
                                </fieldset>
                            </display:column>
                            <display:column headerClass="text-left" property="fullName" title="Tên khách hàng"/>
                            <display:column headerClass="text-left" property="staffName" title="Nhân viên quản lí"/>
                            <display:column headerClass="text-left" property="phone" title="Di động"/>
                            <display:column headerClass="text-left" property="email" title="Email"/>
                            <display:column headerClass="text-left" property="requirement" title="Nhu cầu"/>
                            <display:column headerClass="text-left" property="createdBy" title="Người nhập"/>
                            <display:column headerClass="text-left" property="status" title="Tình trạng"/>

                            <display:column headerClass="col-actions" title="Thao tác">
                                <%--<c:if test="${tableList.roleCode != 'ADMIN'}">--%>
                                <button class="btn btn-xs btn-info" data-toggle="tooltip"
                                        title="Giao khách hàng cho nhân viên quản lí" value="${tableList.id}"
                                        onclick="assignmentCustomer(value)">
                                    <i class="fa fa-fire" aria-hidden="true"></i>
                                </button>
                                <button class="btn btn-xs btn-dark" data-toggle="tooltip"
                                        title="Chỉnh sửa thông tin khách hàng" value="${tableList.id}"
                                        onclick="editCustomer(value)">
                                    <i class="fa fa-edit" aria-hidden="true"></i>
                                </button>

                                <button class="btn btn-xs btn-danger" data-toggle="tooltip"
                                        title="Xoá khách hàng" value="${tableList.id}"
                                    <%--onclick="deleteOneBuilding(value)">--%>
                                        onclick="warningDeleteOne(value)">
                                    <i class="fa fa-remove" aria-hidden="true"></i>
                                </button>
                            </display:column>
                        </display:table>
                    </div>
                </div>
            </div>
        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->
<!-- Modal -->

<div id="assignmentCustomerModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Danh Sách Nhân Viên</h4>
            </div>
            <div class="modal-body">
                <form>
                    <table class="table table-bordered" id="staffList">
                        <thead>
                        <tr>
                            <th class="center">
                                <label class="pos-rel">
                                    <input type="checkbox" id="selectAll2" class="ace"/>
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th class="text-center">Full Name</th>
                        </tr>
                        </thead>
                        <tbody id="dsnv">

                        </tbody>
                    </table>
                </form>
            </div>
            <div class="modal-footer">'
                <button type="button" id="assignment" class="btn btn-default" data-dismiss="modal">Giao khách hàng</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<script> // danh sách nhân viên - bấm vào checkbox - hiển thị all

    var customerId;
    function assignmentCustomer(value) {
        customerId = value;
            $.ajax({
                type: "GET",
                url: "<c:url value='/api/customer'/>" + '/' + value + '/staff',
                dataType: "json",                  // kiểu dữ liệu gửi từ server
                contentType: "application/json",   // gửi từ server

                success: function (response) {
                    var arrCustomer  = response;
                    var row = '';
                    $("#dsnv").empty();
                    arrCustomer.forEach(function(item) {
                        var row = '<tr>'
                                     +  '<td class=text-center>' +
                                           '<input type="checkbox" ' + item.checked + ' name="checkStaffs[]" value="' + item.id  + '" />'
                                     +  '</td>'
                                     +  '<td>'+ item.fullName + '</td>' +
                                  '</tr>'
                        $("#dsnv").append(row);
                    });
                },
                error: function (response) {
                    console.log('faild')
                    console.log(response)
                }
            });
        openModalAssignmentCustomer();
    }

     /!* Giao Khách hàng *!/
    $("#assignment").click(function (e) {
        e.preventDefault();
        var values = [];
        var data = {};
        var checkData = $('input[name="checkStaffs[]"]:checked')

        $.each(checkData, function () {
            values.push($(this).val());
        });
        data["staffIds"] = values;
        data["customerId"] = customerId;

        $.ajax({
            type: "POST",
            url: '<c:url value="/api/customer/assignment"/>',
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                console.log("success");
                window.location.reload();
            },
            error: function (response) {
                alert("fail")
                console.log(response)
            }
        });
    })


    function openModalAssignmentCustomer() {
        $('#assignmentCustomerModal').modal();
    }


    $("#btnSearch").click(function (e) {
        e.preventDefault();
        $("#listForm").submit();
    })


    function editCustomer(value) {
        window.location.href = '<c:url value="/admin/customer-edit" />' + '?customerId=' + value;
    }

    var valueType = ${modelSearch.types} + '';
    if (valueType != '') {
        $.each(valueType, function (index, value) {
            $("#rent[value='" + value + "']").prop('checked', true);
        });
    }


/*    $('#selectAll').change(function() {
        $('input[name="checkBuildings[]"]').prop('checked', this.checked);
    });*/

    // id : selectAll2 -> checkbox - staff
    $("#selectAll2").click(function () {
        $('input[name="checkStaffs[]"]').prop('checked', this.checked);
    })


    function warningDelete() {
        showAlertBeforeDeleteCustomer(function () {
            event.preventDefault();
            var dataArray = $('tbody input[type=checkbox]:checked').map(function () {
                return $(this).val();
            }).get();
            deleteCustomer(dataArray);
        });
    }

    function warningDeleteOne(data) {
        showAlertBeforeDeletes(function () {
            event.preventDefault();
            var dataArray  = [];
            if (data != null) {
                dataArray.push(data);
            }
            deleteCustomer(dataArray);
        }, "customer");
    }

    function deleteCustomer(data) {
        $.ajax({
            url: '<c:url value="/api/customer"/>',
            type: 'DELETE',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (res) {
                window.location.href = "<c:url value='/admin/customer-list?message=delete_success'/>";
            },
            error: function (res) {
                console.log(res);
                window.location.href = "<c:url value='/admin/customer-list?message=error_system'/>";
            }
        });
    }
</script>
</body>
</html>


