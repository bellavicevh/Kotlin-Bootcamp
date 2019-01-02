package Spices
// Practice with subclasses and interfaces.

class Curry(spiciness : String) : Spice("curry", spiciness),
    Grinder, SpiceColor by YellowColor {
    override fun prepareSpice() {
        grind()
    }
}