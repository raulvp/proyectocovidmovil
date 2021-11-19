<?PHP
$hostname_localhost="localhost";
$database_localhost="covidbd";
$username_localhost="root";
$password_localhost="";


//include "../accionesbd/conexionbd.php";
//conectarbd();

$json=array();

		$conex=mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost);

		$consultaPaciente = "select * from paciente";
        
        $resultado_lista=mysqli_query($conex,$consultaPaciente);

		
		
		while($registro=mysqli_fetch_object($resultado_lista )){
			$json[]=$registro;
			
		}
		echo json_encode($json);
		mysqli_close($conex);
		
?>
