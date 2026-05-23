# oop2-patterns5

## Patrón State

**Intención**: La intención del patrón **State** es permitir que un objeto altere su comportamiento cuando cambia su
estado interno, haciendo que parezca que cambia su clase.

It localizes state-specific behavior and partitions behavior for different states. The State pattern puts all behavior
associated with a particular state into one object. Because all state-specific code lives in a State subclass, new
states and transitions can be added easily by defining new subclasses.

**¿Quién define la transición de estado?**: El patrón **State** no especifica qué participante define los criterios de
transición de estado.

Si los criterios son fijos, pueden implementarse completamente en el **Context**. Sin embargo, generalmente es más
flexible y apropiado permitir que las subclases de **State** especifiquen por sí mismas su estado sucesor y cuándo
realizar la transición.

Esto requiere agregar al **Context** métodos que permitan a los objetos **State** establecer explícitamente el
estado actual del **Context**.

Descentralizar la lógica de transición de esta forma facilita modificar o extender la lógica definiendo nuevas subclases
de **State**. Una desventaja de esta descentralización es que una subclase de **State** tendrá conocimiento de al menos
otra, lo que introduce dependencias de implementación entre subclases.

**State vs Strategy**: El patrón **State** suele confundirse con su primo cercano **Strategy**, y a veces es difícil
determinar cuál usar, o si una implementación de uno es en realidad del otro.

Una buena regla práctica para distinguirlos es la siguiente:

- Si el **Context** contendrá solo un objeto (de entre varios posibles) de tipo “State” o “Strategy” durante toda su
  vida, probablemente estás usando **Strategy**.
- Si, en cambio, el **Context** cambia durante el curso normal de la aplicación de modo que, con el tiempo, puede
  contener muchos objetos de "estado" distintos, entonces probablemente se trata de **State**, especialmente si hay
  órdenes de transición bien definidas entre los diferentes estados.

Otra diferencia es que el **Context** parece ocultar la **Strategy** que está usando, pero el **State** que usa es
bastante evidente para su cliente.

Por ejemplo, cuando un cliente le pide a un `StorageDevice` que almacene texto, el dispositivo puede usar distintas
técnicas de compresión (incluso ninguna). Al cliente no le importa cómo comprime, si comprime, o si comprime siempre
igual; solo quiere almacenar y recuperar texto. Como la compresión es privada al dispositivo y está oculta al cliente,
esos objetos de compresión son **Strategies**.

En cambio, cuando un cliente abre una `TCPConnection`, espera que la conexión se comporte como abierta. Si luego la
cierra, espera que se comporte como cerrada. Como el estado de la conexión es evidente para el cliente, esos objetos de
estado son **States**.

**Implementación en conjunto con Double Dispatch**: El patrón **State** se podría implementar también utilizando double
dispatch. En lugar de que los estados realicen lógica, los estados se limitaría exclusivamente a decidir que método del
**Context** se debe llamar a continuación, y el **Context** implementaría toda la lógica de transición u otra lógica
necesaria. Esto tiene pros y contras. La ventaja es que el código de transición se centraliza en el **Context** y el
encapsulamiento del Context es más fuerte. Una contra es que al agregar un nuevo estado no basta con agregar una nueva
clase estado sino que ademas debo modificar el **Context**.
