<?php
include("header.php");
include("db.php");
$hash = mysql_real_escape_string($_GET["hash"]);
$sql = "SELECT level FROM hackers WHERE hash='$hash'";
$query = mysql_query($sql);
$result = mysql_fetch_array($query);
$level = $result["level"]+1;
if ($result) {
	$sql = "SELECT * FROM levels WHERE level='$level'";
	$query = mysql_query($sql);
	$result = mysql_fetch_array($query);
	if ($result) {
	?>
	<h1>Level <?php echo $level.' - '.$result["name"]?></h1>
	<p><?php echo $result["instructions"];?></p>
	<h2>Ukázkový vstup</h2>
	<textarea class="field span12" rows="4"><?php echo $result["example_input"];?></textarea>
	<h2>Ukázkový výstup</h2>
	<textarea class="field span12" rows="4"><?php echo $result["example_output"];?></textarea>
	<br />(konce řádků linuxové nebo windows, whitespace na začátku a na konci výstupu ořezán)
	<h2>Soutěžní vstup</h2>
	<textarea class="field span12" rows="8"><?php echo $result["input"];?></textarea>
	<h2>Tvůj výstup</h2>
	<form method="post" action="verify.php">
		<textarea class="field span12" rows="8" name="output" id="output"></textarea>
		<input type="hidden" name="hash" value="<?php echo $hash?>" /><br />
		<input type="submit" value="Odeslat" class="btn btn-primary" />
		<br /><br />
		<p>Tip: Výstup můžeš odesílat přímo z tvého programu podle API daného tímto formulářem. Vrátí se HTTP 200 OK nebo HTTP 400 Bad Request. Autentifikuješ se hashem. Je zakázáno generovat velké množství výstupů a tím zahlcovat server. Počet pokusů se ukládá.</p>
		Příkaz na API pro curl:
		<div class="well well-small">
		curl -d "output=TVUJ_URL_ENCODED_VYSTUP&hash=TVUJ_HASH" http://IP_ADRESA_SERVERU/verify.php
		</div>
	</form>
	<?php
	}
}
include("footer.php");
?> 