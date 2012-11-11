<?php
$additional_header = '<meta http-equiv="refresh" content="30;url=leaderboard.php">';
include("header.php");
include("db.php");
?>  
	<h1>Pojď si zakódovat, vyhraj ceny a ti nejlepší mají šanci na interview u Google!</h1>
	<br />
	<p><h3 style="display:inline">Aktuální leaderboard:</h3> (Kdo první splní level 8, vyhrává!)</p>
	
	<table class="table table-striped">
		<tr><th>Pořadí</th><th>Nick</th><th>Level</th><th># pokusů</th></tr>
<?php
$sql = "SELECT * FROM hackers ORDER BY level DESC, attempts";
$query = mysql_query($sql);
$i=0;
while ($result = mysql_fetch_array($query)) {
	$i++;
	echo '<tr><td>'.$i.'.</td><td>'.$result["nick"].'</td><td>Level '.$result["level"].'</td><td>'.$result["attempts"].' x</td></tr>';
}
?>
	</table>
<?php
include("footer.php");
?> 