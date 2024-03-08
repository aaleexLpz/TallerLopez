<?php

$servername = "localhost";
$username = "root";
$password = "root";
$dbname = "workshop_db";

$conn = new mysqli($servername, $username, $password, $dbname);

if($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}

$sql = "SELECT * FROM tabla_datos";
$result = $conn->query($sql);

if($resulta->num_rows > 0) {
    echo "<table border='1'>";
    echo "<tr><th>Columna 1</th><th>Columna 2 </th></tr>";
    while($row = $result->fetch_assoc()) {
        echo "<tr><td>" . $row["columna1"] . "</td><td>" . $row["columna2"] . "</td></tr>";
    }
    echo "</table>";
}else{
    echo "No se encontraron resultados";
}

$conn->close();

?>