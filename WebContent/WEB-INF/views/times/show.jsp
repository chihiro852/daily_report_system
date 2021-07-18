<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${time != null}">
                <h2>出退勤　詳細ページ</h2>

                <c:choose>
                    <c:when test="${break_start == null}">
                        <form method="POST" action="<c:url value='/times/breakstart' />">
                            <button type="submit">休憩開始</button>
                        </form>
                    </c:when>
                    <c:when test="${break_end == null && break_start != null}">
                        <form method="POST" action="<c:url value='/times/breakend' />">
                            <button type="submit">休憩終了</button>
                        </form>
                    </c:when>
                    <c:when test="${clock_out == null && clock_in != null}">
                        <form method="POST" action="<c:url value='/times/clockout' />">
                            <button type="submit">退勤</button>
                        </form>
                    </c:when>
                </c:choose>

                <table>
                    <tbody>
                        <tr>
                            <th>氏名</th>
                            <td><c:out value="${time.employee.name}" /></td>
                        </tr>
                        <tr>
                            <th>出勤日時</th>
                            <td><fmt:formatDate value="${time.clock_in}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        <tr>
                            <th>休憩開始日時</th>
                            <td><fmt:formatDate value="${time.break_start}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </td>
                        </tr>
                        <tr>
                            <th>休憩終了日時</th>
                            <td>
                                <fmt:formatDate value="${time.break_end}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        <tr>
                            <th>退勤日時</th>
                            <td>
                                <fmt:formatDate value="${time.clock_out}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                    </tbody>
                </table>
            </c:when>

            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/times/index" />">一覧に戻る</a></p>
    </c:param>
</c:import>