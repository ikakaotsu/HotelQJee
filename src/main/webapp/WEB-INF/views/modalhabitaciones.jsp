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
			<label>Dias Permanencia:</label> <label class="checkbox-inline">
				<input type="checkbox" value="">1
			</label> <label class="checkbox-inline"> <input type="checkbox"
				value="">2
			</label> <label class="checkbox-inline"> <input type="checkbox"
				value="">3
			</label> <label class="checkbox-inline"> <input type="checkbox"
				value="">4
			</label> <label class="checkbox-inline"> <input type="checkbox"
				value="">5
			</label> <label class="checkbox-inline"> <input type="checkbox"
				value="">6
			</label> <label class="checkbox-inline"> <input type="checkbox"
				value="">7
			</label> <label class="checkbox-inline"> <input type="checkbox"
				value="">8
			</label> <label class="checkbox-inline"> <input type="checkbox"
				value="">9
			</label> <label class="checkbox-inline"> <input type="checkbox"
				value="">10
			</label>
		</div>
		<div class="form-group">
			<textarea class="form-control" rows="5" id="comment"></textarea>
		</div>
	</div>
</form>
