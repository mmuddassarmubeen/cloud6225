<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Report Page</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
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

<div class="container-fluid">
    <section class="container">
		<div class="container-page">				
			<div class="col-md-6">
				<h3 class="dark-grey">Report</h3>
				
				<div class="form-group col-lg-12">
					<label>Search</label>
					<input class="form-control"></input>
				</div>
				
				<div class="form-group col-lg-6">
					<label>Start</label>
					<div class='input-group date' id='datetimepickerStart'>
					<input class="form-control" path="start"></input>
					<span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
				</div>
				
				<div class="form-group col-lg-6">
					<label>End</label>
					<div class='input-group date' id='datetimepickerEnd'>
					<input class="form-control" path="end"></input>
					<span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
					
				</div>
							
				<div class="form-group col-lg-12">
					<button id="createEvent" type="submit" class="btn btn-primary">Search</button>
				</div>
			</div>
		
			
		</div>
	</section>
</div>
<table class="table table-striped">
  <tbody>
  <tr>
  	<td>report</td>
  </tr>
  </tbody>
</table>
</body>
</html>