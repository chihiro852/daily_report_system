<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <h2>出退勤　登録ページ</h2>

                <c:if test="${_token == clock_in}">
                    <form method="POST" action="<c:url value='/times/create' />">
                        <button type="submit">出勤</button>
                    </form>
                </c:if>
                <c:if test="${_token == break_start}">
                    <form method="POST" action="<c:url value='/times/create' />">
                        <button type="submit">休憩開始</button>
                    </form>
                </c:if>

                <c:if test="${_token == break_end}">
                    <form method="POST" action="<c:url value='/times/create' />">
                        <button type="submit">休憩終了</button>
                    </form>
                </c:if>

                <c:if test="${_token == clock_out}">
                    <form method="POST" action="<c:url value='/times/create' />">
                        <button type="submit">退勤</button>
                    </form>
                </c:if>

        <p><a href="<c:url value='/times/index' />">一覧に戻る</a></p>
    </c:param>
</c:import>