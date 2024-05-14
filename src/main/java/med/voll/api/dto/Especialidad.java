package med.voll.api.dto;

public enum Especialidad {

        ORTOPEDIA("ortopedia"), 

        GINECOLOGIA("ginecologia"), 

        CARDIOLOGIA("cardiologia"), 

        PEDIATRIA("pediatria");

        private String nombre;

        Especialidad(String nombre){
            this.nombre = nombre;
        }


        public Especialidad convertToMayus(String name){
            for (Especialidad valor : Especialidad.values()) {
                if (name.contains(nombre)) {
                    return valor;
                }
            }
            return null;
        }



}
