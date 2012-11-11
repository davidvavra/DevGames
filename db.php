<?php
$host = "127.0.0.1";
$host_user = "user";
$host_passwd = "passwrd";
$host_db = "devfest";
@$spojeni = MySQL_Connect("$host","$host_user","$host_passwd");
if (!$spojeni):
  echo "Nepodařilo se připojit k databázi!";
  die();
endif;
MySQL_Select_DB("$host_db");
mysql_query('SET NAMES "utf8"');
?>
