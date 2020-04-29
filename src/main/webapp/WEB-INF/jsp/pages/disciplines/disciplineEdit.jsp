<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%----%>
<div class="container-fluid">
    <div class="row">
        <div class="col-1"><a href="/">На главную</a></div>
        <div class="col-1"><a href="#" onclick="history.back()">Назад</a></div>
        <div class="col-8">
            <h5>Для того чтобы модифицировать  дисциплину введите новое значение поля и нажмите кнопку "Применить": </h5>
        </div>
        <div class="col-2"></div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-6">
            <form class="needs-validation was-validated" method="post" action="/discipline-edit">
                <div class="form-group row">
                    <label for="discipline_name" class="col-sm-2 col-form-label">Название </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="discipline_name" name="discipName" value="${discipline.discipline}" required>
                        <input type="hidden" name="idEditDiscipline" value="${discipline.id}">
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Применить</button>
            </form>
        </div>
        <div class="col-6"></div>
    </div>
</div>