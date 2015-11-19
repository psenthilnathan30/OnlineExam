<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="body">
		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-header">Online Examination</h1>
						<div class="panel panel-green">
							<div class="panel-heading">Java Questions</div>
							<div class="panel-body">
								<c:if test="${not empty questionsDetails}">
								
								<form name="onlinetest">
								
									<c:forEach var="excelBean" items="${questionsDetails}">
										<div class="form-group">
											<pre>
												<label class="questionLabel">${excelBean.getQuestion()}</label>
                                            </pre>
                                                                                                                                   
											<div class="radio">
												<label> <input type="radio"
													name="options${excelBean.getRowNum()}"
													id="options${excelBean.getRowNum()}"
													value="${excelBean.getOption_1()}">${excelBean.getOption_1()}
												</label>
											</div>
											<div class="radio">
												<label> <input type="radio"
													name="options${excelBean.getRowNum()}"
													id="options${excelBean.getRowNum()}"
													value="${excelBean.getOption_2()}">${excelBean.getOption_2()}
												</label>
											</div>
											<div class="radio">
												<label> <input type="radio"
													name="options${excelBean.getRowNum()}"
													id="options${excelBean.getRowNum()}"
													value="${excelBean.getOption_3()}">${excelBean.getOption_3()}
												</label>
											</div>
											<div class="radio">
												<label> <input type="radio"
													name="options${excelBean.getRowNum()}"
													id="options${excelBean.getRowNum()}"
													value="${excelBean.getOption_4()}">${excelBean.getOption_4()}
												</label>
											</div>
										</div>
									
									</c:forEach>
									
									</form>
									
								</c:if>
							</div>
							<div class="panel-footer tac">
								<button type="button" class="btn btn-success" id="btnValidate">Submit</button>
							</div>
						</div>
						<!-- /.col-lg-4 -->
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
	</tiles:putAttribute>
</tiles:insertDefinition>

