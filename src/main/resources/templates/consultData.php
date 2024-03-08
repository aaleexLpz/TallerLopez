<?php
	// Conexión a la base de datos
	$conn = new mysqli('localhost', 'root', 'root', 'workshop_db', 3307);
	if ($conn->connect_error) {
		die("Error de conexión: " . $conn->connect_error);
	}

	// Consulta SQL para obtener los datos
	$sql = "SELECT c.nombre AS cliente, ca.brand AS coche, me.nombre AS mecanico, t.location AS taller
			FROM cliente c
			JOIN car ca ON c.car = ca.id
			JOIN mechanic me ON ca.id = me.car
			JOIN taller t ON me.dni = t.mechanic";
	$result = $conn->query($sql);

	if ($result->num_rows > 0) {
		// Mostrar datos en la tabla
		while ($row = $result->fetch_assoc()) {
			echo "<tr>";
			echo "<td>" . $row["cliente"] . "</td>";
			echo "<td>" . $row["coche"] . "</td>";
			echo "<td>" . $row["mecanico"] . "</td>";
			echo "<td>" . $row["taller"] . "</td>";
			echo "</tr>";
		}
	} else {
		echo "<tr><td colspan='4'>No hay datos disponibles</td></tr>";
	}
	$conn->close();
?>