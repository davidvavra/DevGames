<?php
include("header.php");
include("db.php");
$hash = mysql_real_escape_string($_POST["hash"]);
$output = normalize($_POST["output"]);
$sql = "SELECT level FROM hackers WHERE hash='$hash'";
$query = mysql_query($sql);
$result = mysql_fetch_array($query);
$level = $result["level"]+1;
if ($result) {
	$sql = "SELECT output FROM levels WHERE level='$level'";
	$query = mysql_query($sql);
	$result = mysql_fetch_array($query);
	if ($result) {
		$desired_output = normalize($result["output"]);
		mysql_query("UPDATE hackers SET attempts = attempts + 1 WHERE hash='$hash'");
		if ($output == $desired_output) {
			mysql_query("UPDATE hackers SET level = level + 1 WHERE hash='$hash'");
			if ($level == 8) {
				?>
<div class="alert alert-success">
  <strong>DevGames finished!</strong> Congratulations! 
  <embed src="files/win.wav" loop="false" hidden="true" autostart="true">
</div>
 <p>Zastav se u organizátorů pro cenu.</p>
		<?php
			} else {
		?>
<div class="alert alert-success">
  <strong>Level up!</strong> 
  <embed src="files/levelup.wav" loop="false" hidden="true" autostart="true">
</div>
 <p>Pokračuj <a href="assignments.php?hash=<?php echo $hash ?>">dalším levelem</a>.</p>
		<?php
		}
		} else {
		header(':', true, 400);
		?>
<div class="alert alert-error">
  <strong>Nay :(</strong>
</div>
<p><a href="assignments.php?hash=<?php echo $hash ?>">Zkus to znovu</a></p>
		<?php
		}
	}
}
include("footer.php");

function normalize($string) {
	$string = mysql_real_escape_string($string);
	$string = str_replace('\r\n', '\n', $string);
	$string = trim($string);
	return $string;
}
?> 