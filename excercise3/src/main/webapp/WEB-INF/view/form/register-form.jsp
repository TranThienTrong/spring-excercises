<%--
  Author: trong
  Date: 18/08/2021
  Time: 21:07
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Vaccination Registering Form</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet"  href="../../../resource/css/style.css">
    <script src=https://code.jquery.com/jquery-1.12.4.js></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>




</head>
<body>

<script>
    $(document).ready(function () {
        $('.datepicker').datepicker({
            calendarWeeks: true,
            todayHighlight: true,
            autoclose: true
        });
    });

    function checkForm(form) {
        if(!form.agree.checked) {
            alert("Please indicate that you agree to take vaccine");
            form.agree.focus();
            return false;
        }
        return true;
    }
</script>

<div class="form-style-2">
    <div class="form-style-2-heading">VACCINATION REGISTERING FORM</div>

    <form:form action="validatingForm" modelAttribute="person" method="post" onsubmit="return checkForm(this);">
        <label for="field1">
            <span>Full Name <span class="required">*</span></span>
        </label>
        <form:input path="fullName" class="input-field" id="field1" value=""/> <form:errors path="fullName" cssClass="error"/>

        <label for="field2">
            <span>Mobile Number <span class="required">*</span></span>
        </label>
        <form:input path="mobileNumber" type="text" class="input-field" id="field2" value=""/>
        <form:errors path="mobileNumber" cssClass="error"/>

        <label for="field3">
            <span>Birthday <span class="required">*</span></span>
        </label>
        <form:input cssClass="datepicker" path="birthday" id="field3" class="input-field"/>
        <form:errors path="birthday" cssClass="error"/>

        <label for="field4">
            <span>Span <span class="required">*</span></span>
            <select id="field4" class="select-field">
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option>
            </select>
        </label>

        <label for="field5">
            <span>Address (e.g. 364 Cong Hoa) <span class="required">*</span> </span>
        </label>
        <form:textarea path="address" id="field5" class="textarea-field" rows="3" cols="15" />
        <form:errors path="address" cssClass="error"/>

        <br>
        <p><input type="checkbox" name="agree"> I agreed to take vaccine </p>
        <p>All fields with (*) are mandatory </p>
        <input id="submit-btn" type="submit" value="Submit"/>
    </form:form>
</div>

</body>
</html>
