<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="body">
		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-primary">
							<div class="panel-heading">Upload Questions(Note:
								.xslx,xsx)</div>
							<div class="panel-body">
								<c:if test="${message!=null}">
									<button type="button" class="close" data-dismiss="alert"
										aria-hidden="true">&times;</button>
									<div class="alert alert-success alert-dismissable">${message}</div>
								</c:if>
								<form method="POST" action="" enctype="multipart/form-data">
									<div class="form-group">
										<label>File to upload:</label> <input type="file"
											name="fileData">
									</div>
									<input type="button" id="upload" value="Upload"
										class="btn btn-primary " />
									<button type="button" id="previewBtn" class="btn btn-primary"
										data-toggle="modal" data-target="#previewModal">Preview</button>
								</form>
							</div>
							<div class="panel-footer">Panel Footer</div>
						</div>
						<!-- /.col-lg-4 -->
					</div>
					<!-- /.col-lg-12 -->
					<div class="col-md-12">

						<!-- /.col-lg-4 -->
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
		<div class="modal fade" tabindex="-1" role="dialog" id="previewModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">Review</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-green">
							<div class="panel-heading">Review Questions</div>
							<div class="panel-body">
								<table id="questions"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>Question</th>
											<th>Option A</th>
											<th>Option B</th>
											<th>Option C</th>
											<th>Option D</th>
											<th>Category</th>
											<th>Answer</th>
											<th>Description</th>
										</tr>
									</thead>
								</table>
							</div>
							<div class="panel-footer">Panel Footer</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save
							changes</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
	</tiles:putAttribute>
</tiles:insertDefinition>

