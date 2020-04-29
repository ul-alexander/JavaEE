<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<%----%>
<div class="container-fluid">
    <div class="row">
        <div class="col-1"><a href="/">На главную</a></div>
        <div class="col-1"><a href="#" onclick="history.back()">Назад</a></div>
        <div class="col-8">
            <h5>Для того что создать нового студента заполните все поля и нажмите кнопку "Создать": </h5>
        </div>
        <div class="col-2"></div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-6">
            <form class="needs-validation was-validated" method="post" action="/student-create">
                <div class="form-group row">
                    <label for="student_surname" class="col-sm-2 col-form-label">Фамилия </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="student_surname" name="student_surname" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="student_name" class="col-sm-2 col-form-label">Имя </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="student_name" name="student_name" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="student_group" class="col-sm-2 col-form-label">Группа </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="student_group" name="student_group" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="student_start" class="col-2 col-form-label">Дата поступления</label>
                    <div class="col-10">
                        <input class="form-control" type="date" placeholder="<fmt:formatDate value="2020-20-20" pattern="dd/MM/yyyy" />" name="student_start" id="student_start">
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Создать</button>
            </form>
        </div>
        <div class="col-6"></div>
    </div>
</div>

<script>
    $('#student_start').datepicker({
        uiLibrary: 'bootstrap4'
    });
</script>