<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name = "content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>出退勤　一覧</h2>
        <table id="time_list">
            <tbody>
                <tr>
                    <th class="time_name">氏名</th>
                    <th class="time_date">日付</th>
                    <th class="time_action">操作</th>
                </tr>
                <c:forEach var="time" items="${times}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td class="time_name"><c:out value="${report.employee.name}" /></td>
                        <td class="time_date"><fmt:formatDate value='${time.time_date}' pattern='yyyy-MM-dd' /></td>
                        <td class="time_action"><a href="<c:url value='/times/show?id=${time.id}' />">詳細を見る</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${times_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((times_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/times/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/times/new' />">出退勤登録する</a></p>

    </c:param>
</c:import>