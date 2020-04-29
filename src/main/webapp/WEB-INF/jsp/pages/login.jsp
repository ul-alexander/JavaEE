<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%----%>
<div class="container">
    <div class="col-4">
        <form method="post" action="/login">
            <div class="form-group">
                <label for="loginInput">Логин</label>
                <input type="text" class="form-control" id="loginInput" name="login">

            </div>
            <div class="form-group">
                <label for="inputPassword">Пароль</label>
                <input type="password" class="form-control" id="inputPassword" name="password">
            </div>
            <div class="form-group">
                <label for="formControlSelect">Выберите роль</label>
                <select class="form-control" id="formControlSelect" name="role">
                    <option value="1">Администратор</option>
                    <option value="2">Студент</option>
                    <option value="3">Учитель</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Вход</button>
        </form>
    </div>
    <div class="col-8">
        <c:if test="${errorMessage eq 1}">
            <div class="alert alert-danger" role="alert">
                (Ахтунг) Логин , Пароль или Роль неверны!
            </div>
        </c:if>
    </div>
</div>
