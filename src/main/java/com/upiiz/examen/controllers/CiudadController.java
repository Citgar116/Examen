    package com.upiiz.examen.controllers;
    import com.upiiz.examen.models.Ciudad;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import java.util.ArrayList;
    import java.util.List;

    @Controller
    @RequestMapping("/ciudades")
    public class CiudadController {

        private static List<Ciudad> listaCiudades = new ArrayList<>();

        static{
            listaCiudades.add(new Ciudad(1, "Zacatecas", "México", 150000));
            listaCiudades.add(new Ciudad(2, "CDMX", "México", 9200000));
            listaCiudades.add(new Ciudad(3, "Madrid", "España", 3200000));
            listaCiudades.add(new Ciudad(4, "Tokio", "Japón", 13960000));
            listaCiudades.add(new Ciudad(5, "París", "Francia", 2161000));
            listaCiudades.add(new Ciudad(6, "Londres", "Reino Unido", 8982000));
            listaCiudades.add(new Ciudad(7, "Berlín", "Alemania", 3645000));
            listaCiudades.add(new Ciudad(8, "Buenos Aires", "Argentina", 3075000));
            listaCiudades.add(new Ciudad(9, "Roma", "Italia", 2873000));
            listaCiudades.add(new Ciudad(10, "Chile", "Santiago de chile", 5312000));
        }

        @GetMapping
        public String listar(Model models){
            models.addAttribute("ciudades", listaCiudades);
            return "listas";
        }

        @GetMapping("/nuevo")
        public String formularioCrear(Model models) {
            models.addAttribute("ciudad", new Ciudad());
            return "nuevo";
        }

        @PostMapping("/guardar")
        public String guardar(@ModelAttribute Ciudad ciudad)
        {
            listaCiudades.add(ciudad);
            return "redirect:/ciudades";
        }

        @GetMapping("/editar/{id}")
        public String formularioEditar(@PathVariable int id, Model model) {
            Ciudad ciudad = listaCiudades.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
            model.addAttribute("ciudad", ciudad);
            return "editar";

        }
        @PostMapping("/actualizar")
        public String actualizar(@ModelAttribute Ciudad ciudad) {
            listaCiudades.removeIf(c -> c.getId() == ciudad.getId());
            listaCiudades.add(ciudad);
            return "redirect:/ciudades";
        }

        @GetMapping("/eliminar/{id}")
        public String formularioEliminar(@PathVariable int id, Model model) {
            Ciudad ciudad = listaCiudades.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
            model.addAttribute("ciudad", ciudad);
            return "eliminar";
        }

        @PostMapping("/borrar")
        public String borrar(@RequestParam int id) {
            listaCiudades.removeIf(c -> c.getId() == id);
            return "redirect:/ciudades";
        }


    }
