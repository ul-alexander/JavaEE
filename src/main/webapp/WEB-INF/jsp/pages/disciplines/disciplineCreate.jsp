<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%----%>
<div class="container-fluid">
    <div class="row">
        <div class="col-1"><a href="/">На главную</a></div>
        <div class="col-1"><a href="#" onclick="history.back()">Назад</a></div>
        <div class="col-8">
            <h5>Для того что создать новую дисциплину заполните все поля и нажмите кнопку "Создать": </h5>
        </div>
        <div class="col-2"></div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-6">
            <form class="needs-validation was-validated" method="post" action="/discipline-create">
                <div class="form-group row">
                    <label for="discipline_name" class="col-sm-2 col-form-label">Название </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="discipline_name" name="discipName" required>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Создать</button>
            </form>
        </div>
        <div class="col-6"></div>
    </div>
</div>