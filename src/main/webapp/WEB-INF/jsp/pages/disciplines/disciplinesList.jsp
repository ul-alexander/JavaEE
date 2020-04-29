<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%----%>
<div class="container-fluid">
    <div class="row">
        <div class="col-2"><a href="/">На главную</a></div>
        <div class="col-5">
            <table class="table table-hover">
                <thead>
                <tr class="table-dark">
                    <c:if test="${role eq 1}">
                        <th scope="col">#</th>
                    </c:if>
                    <th scope="col">Наименование Дисциалины</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${discep}" var="dis">
                    <tr>
                        <c:if test="${role eq 1}">
                            <th scope="row">
                                <div class="custom-control custom-checkbox">
                                    <input type="checkbox" value="${dis.id}" class="custom-control-input"
                                           id="disciplineCheck${dis.id}">
                                    <label class="custom-control-label" for="disciplineCheck${dis.id}"></label>
                                </div>
                            </th>
                        </c:if>
                        <td>${dis.discipline}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-3">
            <c:if test="${role eq 1}">
                <a href="/discipline-create" class="btn btn-primary btn-md btn-block" role="button" aria-pressed="true">
                    Создать Дисциплину</a>
                <a onclick="modifyDiscipline()" class="btn btn-outline-secondary btn-md btn-block" role="button"
                   aria-pressed="true">Редактировать Дисциплину</a>
                <a onclick="deleteDisciplines()" class="btn btn-outline-danger btn-md btn-block" role="button"
                   aria-pressed="true">
                    Удалить выбранные Дисциплины</a>
            </c:if>
        </div>
        <div class="col-2"></div>
    </div>
</div>

<form id="formModifyDiscipline" action="/discipline-edit" method="get">
    <input type="hidden" id="idModifyDisc" name="idModifyDisc" value="">
</form>

<form id="formDeleteDiscipline" action="/disciplines" method="post">
    <input type="hidden" id="idsDeleteDisc" name="idsDeleteDisc" value="">
</form>