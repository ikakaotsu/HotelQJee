<form>
	<div class="form-row">
		<div class="form-group col-md-4">
			<input type="text" class="form-control" placeholder="Fecha Ingreso">
		</div>
		<div class="form-group col-md-4">
			<input type="text" class="form-control" placeholder="Hora Ingreso">
		</div>
		<div class="form-group col-md-4">
			<input type="text" class="form-control" placeholder="Cant. Personas">
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-4">
			<select id="inputComprobante" class="form-control">
				<option selected>Comprobante</option>
				<option>A</option>
				<option>B</option>
				<option>Excento</option>
			</select>
		</div>
		<div class="form-group col-md-4">
			<input type="text" class="form-control" placeholder="Codigo Factura">
		</div>
		<div class="form-group col-md-4">
			<select id="inputPago" class="form-control">
				<option selected>Pago</option>
				<option>Contado</option>
				<option>Debito</option>
				<option>Credito</option>
			</select>
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-4">
			<select id="inputMedio" class="form-control">
				<option selected>Medio Reserva</option>
				<option>Presencial</option>
				<option>Booking</option>
				<option>Expedia</option>
			</select>
		</div>
		<div class="form-group col-md-4">
			<input type="text" class="form-control"
				placeholder="Tipo de Habiacion">
		</div>
		<div class="form-group col-md-4">
			<select id="inputEstadoH" class="form-control">
				<option selected>Estado Habitacon</option>
				<option>Libre</option>
				<option>Reserva</option>
				<option>Ocupado</option>
			</select>
		</div>
	</div>
	<div class="form-row">
		<div class="form-group col-md-4">
			<select id="inputEstado" class="form-control">
				<option selected>Estado</option>
				<option>Pagado</option>
				<option>Debe</option>
				<option>Falt. Facturar</option>
			</select>
		</div>

		<div class="form-row">
					<div class="input-group">
						<div class="input-group-btn">
							<button tabindex="-1" class="btn btn-default" type="button">Permanencia</button>
							<button tabindex="-1" data-toggle="dropdown" class="btn btn-default dropdown-toggle" type="button">
							<span class="caret"></span>
							</button>
							<ul role="menu" class="dropdown-menu">
								<li><a href="#"><input type="checkbox"><span class="lbl"> Toda la Semana</span></a></li>
								<li class="divider"></li>
								<li><a href="#"><input type="checkbox"><span class="lbl"> Lunes</span></a></li>
								<li><a href="#"><input type="checkbox"><span class="lbl"> Martes</span></a></li>
								<li><a href="#"><input type="checkbox"><span class="lbl"> Miercoles</span></a></li>
								<li><a href="#"><input type="checkbox"><span class="lbl"> Jueves</span></a></li>
								<li><a href="#"><input type="checkbox"><span class="lbl"> Viernes</span></a></li>
								<li><a href="#"><input type="checkbox"><span class="lbl"> Sabado</span></a></li>
								<li><a href="#"><input type="checkbox"><span class="lbl"> Domingo</span></a></li>
							</ul>
						</div>
						<input type="text" class="form-control">
					</div>
					<div class="input-group">
						<div class="input-group-btn">
							<button tabindex="-1" class="btn btn-default" type="button">Aire/Calefaccion</button>
							<button tabindex="-1" data-toggle="dropdown" class="btn btn-default dropdown-toggle" type="button">
							<span class="caret"></span>
							</button>
							<ul role="menu" class="dropdown-menu">
								<li><a href="#"><input type="checkbox"><span class="lbl"> Toda la Semana</span></a></li>
								<li class="divider"></li>
								<li><a href="#"><input type="checkbox"><span class="lbl"> Lunes</span></a></li>
								<li><a href="#"><input type="checkbox"><span class="lbl"> Martes</span></a></li>
								<li><a href="#"><input type="checkbox"><span class="lbl"> Miercoles</span></a></li>
								<li><a href="#"><input type="checkbox"><span class="lbl"> Jueves</span></a></li>
								<li><a href="#"><input type="checkbox"><span class="lbl"> Viernes</span></a></li>
								<li><a href="#"><input type="checkbox"><span class="lbl"> Sabado</span></a></li>
								<li><a href="#"><input type="checkbox"><span class="lbl"> Domingo</span></a></li>
							</ul>
						</div>
						<input type="text" class="form-control">
					</div>
		</div>
		<div class="form-group">
			<textarea class="form-control" rows="5" id="comment"></textarea>
		</div>
	</div>
<script>	
	$(document).ready(function() {
    $("ul.dropdown-menu input[type=checkbox]").each(function() {
        $(this).change(function() {
            var line = "";
            $("ul.dropdown-menu input[type=checkbox]").each(function() {
                if($(this).is(":checked")) {
                    line += $("+ span", this).text() + ";";
                }
            });
            $("input.form-control").val(line);
        });
    });
});
</script>
</form>
