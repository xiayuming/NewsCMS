<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="../css/pintuer.css">
    <link rel="stylesheet" href="../css/admin.css">
    <script src="../js/jQuery.js"></script>
    <script src="../js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 头条轮播列表</strong></div>

    <table class="table table-hover text-center">
        <tr>
            <th width="15%">今日头条ID</th>
            <th width="15%">链接新闻ID</th>
            <th width="30%">轮播标题</th>
            <th width="20%">轮播图片</th>
            <th width="20%">操作</th>
        </tr>

        <form method="post" action="" id="headlistform">
            <input type="hidden" name="headId" id="headId">
            <s:iterator value="list" var="s">
                <tr>
                    <td><s:property value="#s.headId"/></td>
                    <td><s:property value="#s.newsPO.newsId"/></td>
                    <td><s:property value="#s.headTitle"/></td>
                    <td><s:property value="#s.headImg"/></td>
                    <td>
                        <div class="button-group">
                            <a class="button border-red" href="javascript:void(0)"
                               onclick="return del(<s:property value="#s.headId"/>)">
                                <span class="icon-trash-o"></span> 删除
                            </a>
                        </div>
                    </td>
                </tr>
            </s:iterator>
        </form>

    </table>
</div>
<script type="text/javascript">
    function del(headid) {
        if (confirm("您确定要删除此头条吗?")) {
            document.getElementById("headId").value = headid;
            document.getElementById("headlistform").action = "headnews_deleteHeadNews.action";
            document.getElementById("headlistform").submit();
        }
    }
</script>
<div class="panel admin-panel margin-top" id="add">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 编辑头条内容</strong></div>
    <div class="body-content">

        <form method="post" class="form-x" enctype="multipart/form-data"  action="headnews_addOrUpdateHeadNews.action">

            <div class="form-group">
                <div class="label">
                    <label>今日头条ID：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value=""
                           placeholder="请输入头条ID(1-5)" name="headId"
                           data-validate="required:请输入头条ID"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>链接新闻ID：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="newsPO.newsId" value="" placeholder="请输入点击跳转的新闻ID"
                           data-validate="required:请输入新闻ID"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>轮播标题：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="headTitle"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>轮播图片：</label>
                </div>
                <div class="field">
                    <input type="text" id="fileurl" name="img" class="input" style="width:25%; float:left;" value=""
                           data-toggle="hover" data-place="right" placeholder="推荐图片尺寸 1200*550"
                           data-validate="required:请输入头条ID"/>
                    <input type="button" class="button bg-blue margin-left" onclick="myfile.click();"
                           value="选择图片" style="float:left;">
                    <input type="file" name="file" id="myfile" onchange="fileurl.value=this.value"
                           style="display: none;float: left;" >
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 添加/修改</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>