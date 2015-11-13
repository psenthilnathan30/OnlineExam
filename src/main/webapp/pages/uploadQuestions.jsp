<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="body">
		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Upload</h1>
						<div class="panel panel-primary">
							<div class="panel-heading">Upload Questions(Note:
								.xslx,xsx)</div>
							<div class="panel-body">
								<c:if test="${message!=null}">
									<button type="button" class="close" data-dismiss="alert"
										aria-hidden="true">&times;</button>
									<div class="alert alert-success alert-dismissable">${message}</div>

								</c:if>
								<form method="POST" action="uploadFile.do"
									enctype="multipart/form-data">
									File to upload: <input type="file" name="fileData"> <input
										type="submit" value="Upload" />
								</form>
							</div>
							<div class="panel-footer">Panel Footer</div>
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

