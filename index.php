<?php
include("header.php");
?>      
      <h1>Vítej!</h1>
      <p>Když vidíš tuto stránku, znamená to že jsi správně připojen k serveru.
      <h2>Pravidla</h2>
      <ul>
        <li>Čeká tě programovací soutěž, která má celkem 8 levelů, kdo první pokoří level 8, vyhrál.</li>
        <li>Pokud nikdo nedá level 8 do 17.15, určí se pořadí podle dosaženého levelu - v případě shody podle nižšího počtu pokusů.</li>
        <li>Kódování můžeš přerušovat, první 4 levely by se měly dát stihnout do 15ti minut = o přestávkách.</li>
        <li>Můžeš používat libovolný programovací jazyk nebo jiné nástroje (např. papír a tužku<big>☺</big>), porovnává se jenom výstup programu.</li>
        <li>Na úlohách může pracovat jenom jeden stejný člověk, <strong>zákaz práce v týmu a pomoc přítele na internetu.</strong></li>
        <li>Nesmíš automaticky generovat mraky možných výstupů na server s tím, že se náhodou trefíš do správného řešení. Počet pokusů se ukládá!</li>
      </ul>
      <h2>Ceny</h2>
      <ul>
        <li>Každý účastník dostane DevGames badge.</li>
        <li>Kdo se dostane do levelu 5 dostane speciální badge a malou pozornost.</li>
        <li>První 3 dostanou figurku Androida.</li>
        <li>První 3, kteří splňují podmínky, mají šanci po 18té hodině projít screeningem na pozici <a href="http://www.google.com/about/jobs/locations/london/engineering/swe/software-engineer-google-com-london.html">Sofware Engineer</a> u Google. Podmínky:
          <ul>
            <li>vážný zájem o práci pro Google v zahraničí</li>
            <li>vytištěné aktuální CV v angličtině s sebou</li>
          </ul>
        </li>
      </ul>
      <h2>Registrace</h2>
      <form method="post" action="register.php">
        <label for="nick">Nick, který se bude ukazovat na <a href="leaderboard.php">leaderboardu</a>:</label>
        <input type="text" name="nick" id="nick" />
        <label for="email">E-mail, na který ti přijde info o cenách:</label>
        <input type="text" name="email" id="email" />
        <br /><br />
        <input type="submit" value="Let the DevGames begin!" class="btn btn-primary"/>
      </form>
<?php
include("footer.php");
?>         
