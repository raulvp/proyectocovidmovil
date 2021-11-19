<?PHP
$hostname_localhost="localhost";
$database_localhost="covidbd";
$username_localhost="root";
$password_localhost="";


//include "../accionesbd/conexionbd.php";
//conectarbd();

$json=array();


	if(isset($_GET["nombres"]) && isset($_GET["apellidos"]) && isset($_GET["carnet"])
     && isset($_GET["estasalud"]) && isset($_GET["municipio"]) && isset($_GET["dosis"])
     && isset($_GET["proxvacuna"]) && isset($_GET["servsaludlista"]) && isset($_GET["proveedor"])
     && isset($_GET["fechaNac"]) && isset($_GET["fechaVac"])){

		$nombres=$_GET['nombres'];
		$apellidos=$_GET['apellidos'];
		$carnet=$_GET['carnet'];
		$estsalud=$_GET['estasalud'];
		$municipio=$_GET['municipio'];
		$dosis=$_GET['dosis'];
		$proxvacuna=$_GET['proxvacuna'];
        $servicioSalud=$_GET['servsaludlista'];
        $proveedor=$_GET['proveedor'];
        $fechaNac=$_GET['fechaNac'];
        $fechavacunacion=$_GET['fechaVac'];


		$conex=mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost);

		$sql = "INSERT INTO paciente (idPaciente, nombres, apellidos, cedula, fechaNac, serviciosSalud, municipio, establecimiento, fechaVac, dosis, proveedor, proxVac)
     VALUES ('NULL', '{$nombres}', '{$apellidos}', '{$carnet}', '{$fechaNac}', '{$servicioSalud}', '{$municipio}', '{$estsalud}', '{$fechavacunacion}', '{$dosis}', '{$proveedor}', '{$proxvacuna}')";
        
        $resultado_insert=mysqli_query($conex,$sql);

		if($resultado_insert){
            //echo "ingreso insert";
			$consulta="SELECT * FROM paciente ORDER BY idPaciente DESC LIMIT 1";

			//SELECT * FROM Table ORDER BY ID DESC LIMIT 1

			$resultado=mysqli_query($conex,$consulta);
            
            
			if($registro=mysqli_fetch_array($resultado)){
				$json['paciente'][]=$registro;
			}
			mysqli_close($conex);
			echo json_encode($json);
		}
		else{
			$resulta["nombre"]='No Registra';
			$resulta["apellidos"]='No Registra';
			$resulta["carnet"]='No Registra';
			$resulta["estasalud"]='No Registra';
            $resulta["municipio"]='No Registra';
            $resulta["dosis"]='No Registra';
            $resulta["proxvacuna"]='No Registra';
            $resulta["servsaludlista"]='No Registra';
            $resulta["proveedor"]='No Registra';
            $resulta["fechaNac"]='No Registra';
            $resulta["fechaVac"]='No Registra';
            
            
			$json['paciente'][]=$resulta;
			echo json_encode($json);
		}

	}
	else{
            $resulta["nombre"]='WS No Retorna';
            $resulta["apellidos"]='WS No Retorna';
            $resulta["carnet"]='WS No Retorna';
            $resulta["estasalud"]='WS No Retorna';
            $resulta["municipio"]='WS No Retorna';
            $resulta["dosis"]='WS No Retorna';
            $resulta["proxvacuna"]='WS No Retorna';
            $resulta["servsaludlista"]='WS No Retorna';
            $resulta["proveedor"]='WS No Retorna';
            $resulta["fechaNac"]='WS No Retorna';
            $resulta["fechaVac"]='WS No Retorna';
			$json['paciente'][]=$resulta;
			echo json_encode($json);
		}

?>
