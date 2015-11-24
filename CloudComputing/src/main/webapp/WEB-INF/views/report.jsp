<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Report Page</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css">
  <link rel="stylesheet" 
href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.9.1/bootstrap-table.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>

<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>

  <script type="text/javascript">
  
  function loadData()
  {
	  var searchText = document.getElementById("search").value;
	  var empData = {};
	  
	  
	  $.post( "report", { lastName: searchText})
	  .done(function( data ) {
	    empData = data;
	    
	    $('#Employees').DataTable({
		    data: data,
		    aoColumns: [
					  { sTitle: "Employee ID", mDataProp: "empId" },
		              { sTitle: "First Name", mDataProp: "firstname" },
		              { sTitle: "Last Name", mDataProp: "lastname" },
		              { sTitle: "Hire Date", mDataProp: "hireDate" },
		              { sTitle: "Birth Date", mDataProp: "birthDate" }
		          ],
		     bDestroy: true,
		});
	  });
  }
  </script>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="col-md-offset-2">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#" style="color:green">REPORT</a></li>
      </ul>
    </div>
  </div>
</nav>

<form method="POST" action="report">
<div class="container-fluid">
    <section class="container">
		<div class="container-page">				
			<div class="col-md-6">
				<h3 class="dark-grey">Report</h3>
				
				<div class="form-group col-lg-12">
					<label>Search</label>
					<input name="search" id="search" class="form-control"></input>
				</div>
				
				<div class="form-group col-lg-6">
					<label>Start</label>
					<div class='input-group date' id='datetimepickerStart'>
					<input class="form-control"></input>
					<span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
				</div>
				
				<div class="form-group col-lg-6">
					<label>End</label>
					<div class='input-group date' id='datetimepickerEnd'>
					<input class="form-control"></input>
					<span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
					
				</div>
							
				<div class="form-group col-lg-12">
					<button id="createEvent" type="button" class="btn btn-primary" onclick="loadData()">Search</button>
				</div>
			</div>
		
			
		</div>
	</section>
</div>

<table id="Employees">
</table>
</form>
<script type="text/javascript">
$(document).ready(function() {
	$('#datetimepickerStart').datepicker();
	$('#datetimepickerEnd').datepicker();
		
	
});
</script>

</body>
</html>