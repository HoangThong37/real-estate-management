<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách tòa nhà</title>
</head>
<body>

<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>
                <li class="active">Dashboard</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="row">
                <div class="widget-box">
                    <div class="widget-header">
                        <h4 class="widget-title">Tìm kiếm</h4>
                        <div class="widget-toolbar">
                            <a href="#" data-action="collapse">
                                <i class="ace-icon fa fa-chevron-up"></i>
                            </a>
                        </div>

                        <div class="widget-body">
                            <div class="widget-main">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <!-- PAGE CONTENT BEGINS -->
                                        <div class="col-sm-6">
                                            <div>
                                                <label for="name">Tên tòa nhà</label>
                                                <input type="text" id="name" class="form-control" />
                                            </div>
                                        </div>

                                        <div class="col-sm-6">
                                            <div>
                                                <label for="name">Diện tích sàn</label>
                                                <input type="number" id="areaRent" class="form-control" />
                                            </div>
                                        </div>

                                        <div class="col-sm-4">
                                            <div>
                                                <label for="name">Quận hiện có</label>
                                                <select class="form-control" aria-label="Default select example">
                                                    <option selected>--Chọn quận--</option>
                                                    <option value="1">One</option>
                                                    <option value="2">Two</option>
                                                    <option value="3">Three</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-sm-4">
                                            <div>
                                                <label for="name">Phường</label>
                                                <input type="text" id="ward" class="form-control" />
                                            </div>
                                        </div>

                                        <div class="col-sm-4">
                                            <div>
                                                <label for="name">Đường</label>
                                                <input type="text" id="street" class="form-control" />
                                            </div>
                                        </div>

                                        <div class="col-sm-4">
                                            <div>
                                                <label for="name">Số tầng hầm</label>
                                                <input type="text" id="numberOfBasement" class="form-control" />
                                            </div>
                                        </div>

                                        <div class="col-sm-4">
                                            <div>
                                                <label for="name">Hướng</label>
                                                <input type="text" id="direction" class="form-control" />
                                            </div>
                                        </div>

                                        <div class="col-sm-4">
                                            <div>
                                                <label for="name">Hạng</label>
                                                <input type="text" id="level" class="form-control" />
                                            </div>
                                        </div>

                                        <div class="col-sm-3">
                                            <div>
                                                <label for="name">Diện tích từ</label>
                                                <input type="text" id="areaRentFrom" class="form-control" />
                                            </div>
                                        </div>
                                        <div class="col-sm-3">
                                            <div>
                                                <label for="name">Diện tích đến</label>
                                                <input type="text" id="areaRentTo" class="form-control" />
                                            </div>
                                        </div>
                                        <div class="col-sm-3">
                                            <div>
                                                <label for="name">Gía thuê từ</label>
                                                <input type="text" id="costRentFrom" class="form-control" />
                                            </div>
                                        </div>
                                        <div class="col-sm-3">
                                            <div>
                                                <label for="name">Gía thuê đến</label>
                                                <input type="text" id="costRentTo" class="form-control" />
                                            </div>
                                        </div>

                                        <div class="col-sm-4">
                                            <div>
                                                <label for="name">Tên quản lí</label>
                                                <input type="text" id="nameManage" class="form-control" />
                                            </div>
                                        </div>

                                        <div class="col-sm-4">
                                            <div>
                                                <label for="name">Điện thoại quản lý</label>
                                                <input type="text" id="phoneManage" class="form-control" />
                                            </div>
                                        </div>
                                        <div class="col-sm-3">
                                            <div>
                                                <label for="name">Chọn nhân viên quản lý</label>
                                                <select class="form-control" id="staffId" aria-label="Default select example">
                                                    <option selected>--Chọn nhân viên phụ trách--</option>
                                                    <option value="1">One</option>
                                                    <option value="2">Two</option>
                                                    <option value="3">Three</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-sm-3">
                                            <input class="" type="checkbox" value="" id="checkbox1">
                                            <label class="" >
                                                Tầng trệt
                                            </label>

                                            <input class="" type="checkbox" value="" id="checkbox2" checked>
                                            <label class="" >
                                                Nguyên căn
                                            </label>

                                            <input class="" type="checkbox" value="" id="checkbox3" checked>
                                            <label class="" >
                                                Nội thất
                                            </label>
                                        </div>


                                        <div class="col-sm-12">
                                            <button type="button" class="btn btn-sm btn-success">
                                                Tìm kiếm
                                                <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
                                            </button>
                                        </div>
                                        <!-- PAGE CONTENT ENDS -->
                                    </div><!-- /.col -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!-- /.row -->


                <div class="row">
                    <div class="col-xs-12">
                        <div class="pull-right">
                            <button type="button" class="btn btn-success" data-toggle="tooltip"
                                    title="Thêm tòa nhà">
                                <i class="fa fa-plus-circle" aria-hidden="true"></i>
                            </button>

                            <button type="button" class="btn btn-danger " data-toggle="tooltip"\
                                    title="Xóa tòa nhà" id="btnDeleteBuilding">
                                <i class="fa fa-trash" aria-hidden="true"></i>
                            </button>
                        </div>
                    </div>
                </div>
                <br/>

                <div class="row">
                    <div class="col-xs-12">
                        <table id="buildingList" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th></th>
                                <th>Tên sản phẩm</th>
                                <th>Địa chỉ</th>
                                <th>Tên quản lí</th>
                                <th>Số điện thoại</th>
                                <th>D.T sàn</th>
                                <th>Gía thuê</th>
                                <th>Phí dịch vụ</th>
                                <th>Thao tác</th>
                            </tr>
                            </thead>

                            <tbody>
                            <tr>
                                <td><input type="checkbox" value="1" id="checkbox_1"></td>
                                <td>Building Tower</td>
                                <td>Quận Bình Thạnh</td>
                                <td>a Bắc</td>
                                <td>0939387475</td>
                                <td>150</td>
                                <td>145</td>
                                <td>45</td>
                                <td>
                                    <button class="btn btn-xs" data-toggle="tooltip"
                                            title="Giao tòa nhà" onclick="assingmentBuilding(1)">
                                        <i class="fa fa-home" aria-hidden="true"></i>
                                    </button>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div><!-- /.main-content -->

<div class="modal fade" id="assignmentBuildingModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Giao tòa nhà cho nhân viên</h4>
            </div>

            <div class="modal-body">
                <table class="table table-bordered" id="staffList">
                    <thead>
                    <tr>
                        <th>Choose Staff</th>
                        <th>Name Staff</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><input type="checkbox" value="1" id="customCheck1" checked></td>
                        <td>staff a</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" value="2" id="customCheck2" checked></td>
                        <td>staff b</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" value="3" id="customCheck3" checked></td>
                        <td>staff c</td>
                    </tr>
                    </tbody>
                </table>
                <input type="hidden" name="buildingId" id="buildingId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnAssignBuilding">Giao tòa nhà</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

<script>
    function assingmentBuilding(buildingId) {
        openModalAssingmentBuilding();
        $("#buildingId").val(buildingId);
        console.log($("#buildingId").val());
    }

    function openModalAssingmentBuilding() {
        $('#assignmentBuildingModal').modal();
    }

    $('#btnAssignBuilding').click(function (e) {
        e.preventDefault();
        //call api
        var data ={};
        var staffs = [];
        data['buildingId'] = $('#buildingId').val();
        // $('#staffList').find('tbody input[type=checkbox]:checked')
        // đoạn code này tương tự staff = [1,2,3], là 1 mảng chứa staff
        var staffs = $('#staffList').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['staffs'] = staffs;
        assignStaff(data);
    });

    function assignStaff(data) {
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api-user-assignment",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",

            success: function (response) {
                console.log('success');
            },
            error: function (response) {
                console.log('faild')
                console.log(response)
            }
        });
    }

    $('#btnDeleteBuilding').click(function (e) {
        e.preventDefault();
        var data = {};
        var buildingIds = $('#buildingList').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['buildingIds'] = buildingIds; // push buildingIds vào data
        deleteBuilding(data);
    });

    function deleteBuilding(data) {
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/api-deleteBuilding",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",

            success: function (response) {
                console.log('success');
            },
            error: function (response) {
                console.log('faild')
                console.log(response)
            }
        });
    }
</script>

</body>
</html>
