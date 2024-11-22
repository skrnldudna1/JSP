## JSP & JSTL 💻

### ✔JSP (Java Server Pages)
JSP는 서버 측에서 동적으로 HTML을 생성하는 기술입니다. Java 코드를 HTML 안에 삽입해, 사용자가 요청할 때마다 페이지가 달라질 수 있도록 만들어줍니다. 덕분에 Java 기반의 웹 애플리케이션을 빠르게 개발할 수 있어요.

### ✔JSTL (JSP Standard Tag Library)
JSTL은 JSP에서 사용할 수 있는 표준 태그 라이브러리로, 반복문, 조건문 등 자주 쓰는 기능들을 간단한 태그로 처리할 수 있게 해주며 자바 코드의 복잡성을 줄이고 HTML과의 결합을 깔끔하게 만들어줍니다.

**쉽게 말해, JSP는 웹 페이지를 동적으로 만들어주고, JSTL은 그 작업을 더 간단하고 읽기 쉽게 도와주는 조력자에요.**

<br> <br>

### 한눈에 보는 jstl
```js
<c:choose>
  <c:when test="${condition}">
    조건이 참일 때 실행됩니다.
  </c:when>
  <c:otherwise>
    조건이 거짓일 때 실행됩니다.
  </c:otherwise>
</c:choose>

<c:forEach var="item" items="${itemList}">
  <p>${item}</p>
</c:forEach>

<c:if test="${userLoggedIn}">
  <p>환영합니다, 사용자님!</p>
</c:if>

<c:set var="greeting" value="Hello, World!" />
<p>${greeting}</p>


### 폴더 List   
1. JSP - 기본적인 JSTL 표기법을 설명하는 코드 예제
2. JSTL - JSTL을 활용해 작성한 실습 예제 코드

 
