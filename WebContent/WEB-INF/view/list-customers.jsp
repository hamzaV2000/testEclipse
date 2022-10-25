<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <title>List Customers</title>

    <link type="text/css" rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css"/>

  </head>
  <body>
    <div id="wrapper">
      <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
      </div>
    </div>

    <div id="container">
      <div id="content">
      <input type="button" value="Add Customer"
      onClick="window.location.href = 'showFormForAdd'; return false;"
      class="add-button"/>
      <!--  add a search box -->
       <form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />
                 <input type="submit" value="Search" class="add-button" />
        </form:form>
        <input type="button" value="Sort" onClick="window.location.href = 'sort'; return true;" class="sort-button" />
        <!-- add table -->
        <table>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Action</th>
          </tr>

          <!-- loop over customers -->
          <c:forEach var="customer" items="${customersList}">
             <c:url var="updateLink" value="/customer/showFormForUpdate">
               <c:param name="customerId" value="${customer.id}"/>
             </c:url>
             
             <c:url var="deleteLink" value="/customer/delete">
               <c:param name="customerId" value="${customer.id}"/>
             </c:url>
             
            <tr>
              <td>${customer.firstName}</td>
              <td>${customer.lastName}</td>
              <td>${customer.email}</td>
              <td>
                 <a href="${updateLink}">Update</a>
                 |
                 <a href="${deleteLink}" onclick="if ((!confirm('Are your sure ? '))) return false">Delete</a>
              </td>
            </tr>

          </c:forEach>
        </table>

      </div>
    </div>
  </body>

</html>
