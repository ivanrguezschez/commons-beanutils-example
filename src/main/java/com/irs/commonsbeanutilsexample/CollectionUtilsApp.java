package com.irs.commonsbeanutilsexample;

import com.irs.commonsbeanutilsexample.vo.UsuarioVO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.TransformerClosure;

/**
 * Clase Aplicacion de utilidades de la clase de apache commons beanutils
 * CollectionUtils.
 *
 * @author IRS
 * @version 1.0.0
 */
public class CollectionUtilsApp {

    public static void main(String[] args) {
        try {
            Date fechaAlta = Calendar.getInstance().getTime();
                      
            UsuarioVO u1 = buildUsuario(Integer.valueOf(1), "000000001", "nombre-01", "apellido1-01", "apellido2-01", fechaAlta);
            UsuarioVO u2 = buildUsuario(Integer.valueOf(2), "000000002", "nombre-02", "apellido1-02", "apellido2-02", fechaAlta);
            UsuarioVO u3 = buildUsuario(Integer.valueOf(3), "000000003", "nombre-03", "apellido1-03", "apellido2-03", fechaAlta);
              
            List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
            usuarios.add(u1);
            usuarios.add(u2);
            usuarios.add(u3);

            Collection<Integer> ids = CollectionUtils.collect(usuarios, new BeanToPropertyValueTransformer("idUsuario"));
            System.out.println("IDS");
            for (Integer id : ids) {
                System.out.println("id: " + id);
            }

            Collection<String> nifs = CollectionUtils.collect(usuarios, new BeanToPropertyValueTransformer("nif"));
            System.out.println("NIFS");
            for (String nif : nifs) {
                System.out.println("nif: " + nif);
            }

            Collection<Date> fechasAlta = CollectionUtils.collect(usuarios, new BeanToPropertyValueTransformer("fechaAlta"));
            System.out.println("FECHAS ALTA");
            for (Date fa : fechasAlta) {
                System.out.println("fechaAlta: " + fa);
            }

            System.out.println("ANTES");
            for (UsuarioVO u : usuarios) {
                System.out.println(u);
            }
            //PROBAR UN CLOUSURE para por ejemplo transformar en mayusculas todos los campos
            //BeanPropertyValueChangeClosure                    
            /*
            // Opcion 1
            CollectionUtils.forAllDo(usuarios, new Closure() {
                @Override
                public void execute(Object input) {
                    UsuarioVO u = (UsuarioVO) input;
                    u.setApellido1(u.getApellido1().toUpperCase());
                }
            });
             */

            // Opcion 2
            Transformer upperApellido1Transformer = new Transformer() {
                @Override
                public Object transform(Object input) {
                    UsuarioVO u = (UsuarioVO) input;
                    u.setApellido1(u.getApellido1().toUpperCase());

                    return u;
                }
            };
            CollectionUtils.forAllDo(usuarios, TransformerClosure.getInstance(upperApellido1Transformer));

            System.out.println("DESPUES");
            for (UsuarioVO u : usuarios) {
                System.out.println(u);
            }
            
            Transformer upperApellido2Transformer = new Transformer() {
                @Override
                public Object transform(Object input) {
                    UsuarioVO u = (UsuarioVO) input;
                    u.setApellido2(u.getApellido2().toUpperCase());

                    return u;
                }
            };
            CollectionUtils.forAllDo(usuarios, TransformerClosure.getInstance(upperApellido2Transformer));
            System.out.println("DESPUES");
            for (UsuarioVO u : usuarios) {
                System.out.println(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static UsuarioVO buildUsuario(Integer idUsuario, String nif, 
            String nombre, String apellido1, String apellido2, Date fechaAlta) {
        UsuarioVO usuario = new UsuarioVO();
        usuario.setIdUsuario(idUsuario);
        usuario.setNif(nif);
        usuario.setNombre(nombre);
        usuario.setApellido1(apellido1);
        usuario.setApellido2(apellido2);
        usuario.setFechaAlta(fechaAlta);

        return usuario;
    }
}
