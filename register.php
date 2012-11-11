<?php
include("header.php");
include("db.php");
$nick = mysql_real_escape_string($_POST["nick"]);
$email = mysql_real_escape_string($_POST["email"]);
$hash = sha1(rand(0,100000));
$sql = "SELECT * FROM hackers WHERE nick = '$nick' || email = '$email' || hash ='$hash'";
$result = mysql_query($sql);
$num_rows = mysql_num_rows($result);
if ($num_rows > 0) {
	echo '<h2>Nemůžeš se registrovat znovu</h2><p>Pokud jsi zapomněl hash, kontaktuj orga</p>';
} else {
$sql = "INSERT INTO hackers (nick, email, hash, level, attempts) VALUES ('$nick', '$email', '$hash', 0, 0)";
$result = mysql_query($sql);
if ($result) {
?>  
	<h1>Úspěšně zaregistrován!</h1>
	<p>Tvůj hash je: <strong><?php echo $hash ?></strong></p>
	<p>Hash si někam ulož, budeš ho potřebovat ke všem dalším requestům na server.</p>
	<p>A nyní se můžeš rovnou pustit do <a href="assignments.php?hash=<?php echo $hash?>">prvního úkolu</a>!</p>
<?php
} else {
	echo "Nepodařilo se uložit registraci do databáze: ".$sql;
}
}
include("footer.php");
?> 