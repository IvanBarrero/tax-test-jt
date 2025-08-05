SELECT * FROM public.impuestos;

DELETE FROM public.impuestos;

select i1_0.sticker,i1_0.fecha_movimiento,i1_0.fecha_recaudo,i1_0.nro_form,i1_0.nro_id,i1_0.tipo_horario,i1_0.valor
from impuestos i1_0 where i1_0.fecha_movimiento='2025-03-11';
