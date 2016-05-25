<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <form:form action="${pageContext.request.contextPath}/Register" method="post"
                   commandName="usersDetail">
				   
				    <div class="span9 margin-top">
                   <div class="span9 center margin-bottom"> 
					<h3>Registration Form</h3>
					</div>
				   
				  <div class="span3 no_margin_left">
						<legend>Your Personal Details</legend>
					  <div class="control-group">
						<label class="control-label">Name</label><form:errors path="userFullName" cssStyle="color: #ff0000"/>
						<div class="controls docs-input-sizes">
            				<form:input path="userFullName" id="fullname" class="form-Control"/>
						</div>
					  </div>
					  <div class="control-group">
						<label class="control-label">Email</label><span style="color: #ff0000">${emailMsg}</span>
						   <form:errors path="userEmail" cssStyle="color: #ff0000"/>
						<div class="controls docs-input-sizes">
						  <form:input path="userEmail" id="email" class="form-Control"/>
						</div>
					  </div>					  
					  <div class="control-group">
						<label class="control-label">Phone</label>
						<div class="controls docs-input-sizes">
						  <form:input path="userPhone" id="phone" class="form-Control"/>
						</div>
					  </div>
					<div class="control-group">
						<label class="control-label">Username</label><span style="color: #ff0000">${usernameMsg}</span><form:errors
               					 path="username" cssStyle="color: #ff0000"/>
						<div class="controls docs-input-sizes">
						  <form:input path="Username" id="username" class="form-Control"/>
						</div>
					  </div>
						<div class="control-group">
						<label class="control-label">Password</label><form:errors path="password" cssStyle="color: #ff0000"/>
						<div class="controls docs-input-sizes">
						  <form:password path="password" id="password" class="form-Control"/>
						</div>
					  </div>						  
				   </div>
		  <div class="span8 center">
					  			<input type="submit" value="submit" class="btn btn-primary"  />
							  <a href="<c:url value="/" />" class="btn btn-danger margin-left25">Cancel</a>
								</div>
								</form:form>
		