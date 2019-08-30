package io.carlosaltamirano.facturacion.pruebasIntegracion.core.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.carlosaltamirano.facturacion.core.exception.FacturacionWebException;
import io.carlosaltamirano.facturacion.core.exception.RucEmpresaExisteException;
import io.carlosaltamirano.facturacion.core.model.Empresa;
import io.carlosaltamirano.facturacion.core.service.EmpresaService;
import io.carlosaltamirano.facturacion.test.categoria.PruebaIntegracion;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Category(PruebaIntegracion.class)
public class EmpresaServiceTest {

    @Autowired
    EmpresaService empresaService;

    private Empresa empresa;

    @Before
    public void setUp() {
        empresa = new Empresa("22552255123", "MI EMPRESA S.A.C");
    }

    @After
    public void destroy() {

        try {
            empresaService.eliminar(empresa);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Test
    public void a_creacionEmpresaConDatosValidos() {

        try {
            empresa = empresaService.crear(empresa);

            //Puntos de verificación

            //1. Campo id no debe ser nulo
            Assert.assertNotNull(empresa.getId());

            //2. Campo id debe ser mayor a cero
            Assert.assertTrue(empresa.getId() > 0);

        } catch (Exception e) {
            Assert.fail();
        }

    }

    @Test
    public void b_creacionEmpresaCuandoRucExiste() {

        //TODO: completar

    }


}
