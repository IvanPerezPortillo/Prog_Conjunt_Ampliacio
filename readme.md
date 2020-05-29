## Ampliació. Programació genèrica  
Imaginem que volem fer un objecteCaixaque pot contindre un enter. Ho fariem així:

`public classCaixa {  
    private int t; 
    public voidset(int t) {this.t = t; }
    public intget() {return t; }
}`

Com podem veure és molt pesat, ja que deuriem de programar una classeCaixaper a cadascun delstipus de dades que existeixen. Inclos un per al tipusObject, per a poder contenir objectes i tot. La solució és fer contenidos genèrics, capaços de contenir qualssevol tipus de informació, senseimplementar-ho tantes vegades com tipus existeixen. Si es fixeu ja els heu fet servir (i no és el polimor-fisme), ens referim a l’ArrayList, que ens permet crear el ArrayList, determinant el tipus dels elementsque guardarà en el moment de la seua declaració.

- ArrayList<Integer> elsNumeros=newArrayList<>();
- ArrayList<String> lesParaules=newArrayList<>();  
- ArrayList<Boolean> elsBooleans=newArrayList<>();  

Com s’aconsegueix això? doncs parametritzant la classe. Diguent que el tipus de dades que contindràés una variable, normalment representada per la lletraTmajúscula (detype) i allà on hem de posar eltipus de dades, posaremT. A la nostra caixa.  

Implementar la classeConjuntper a que sigui capaç de contindre elements de diversa naturalesa,això si, tots del mateix tipus






