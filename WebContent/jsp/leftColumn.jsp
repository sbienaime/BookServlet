

<!--  get init paramater param1 -->

<link rel="stylesheet" href="css/bookstore.css" type="text/css" />
<script src="js/bookstore.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
</head>
<div class="leftbar">
	<ul id="menu">
		<li><div>
				<a class="link1" href="<!--   init paramater param1 goes here -->"> <span class="label"
					style="margin-left: 15px;">Home</span>
				</a>
			</div></li>
		<li><div>
				<a class="link1" href="<!--   init paramater param1 goes here -->?action=allBooks"><span
					style="margin-left: 15px;" class="label">All Books</span></a>
			</div></li>
		<li><div>
				<span class="label" style="margin-left: 15px;">Categories</span>
			</div>
			<ul>
			<!--   get categoryList attribute -->
			<!--   for each category do the following -->
				
				<li><a class="label"
					href="<!--  param1 goes here -->?action=category&categoryId=<!--  category id goes here -->&category=<!--  category description goes here -->"><span
						class="label" style="margin-left: 30px;"><!--  category description goes here --></span></a>
				</li>
		     <!--   end for each category -->
			</ul></li>
		<li><div>
				<span class="label" style="margin-left: 15px;">Contact Us</span>

			</div></li>
	</ul>
	<form class="search">
		<input type="hidden" name="action" value="search" /> <input id="text"
			type="text" name="keyword" size="12" /> <span
			class="tooltip_message">?</span>
		<p />
		<input id="submit" type="submit" value="Search" />
	</form>


</div>






