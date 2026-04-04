/**
 * A child is playing with a ball on the nth floor of a tall building.
 * He drops the ball out of the window. The ball bounces to two-thirds of its height
 * His mother looks out of a window 1.5 meters from the ground
 * How many times will the mother see the ball pass in front of her window
 * (including when it's falling and bouncing)?
 * <p>
 * Float parameter "h" in meters must be greater than 0
 * Float parameter "bounce" must be greater than 0 and less than 1
 * Float parameter "window" must be less than h.
 * If all three conditions above are fulfilled, return a positive integer, otherwise return -1.
 * <p>
 * Note:
 * The ball can only be seen if the height of the rebounding ball
 * is strictly greater than the window parameter.
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {


    double h = 30.0;
    double bounce = 0.66;
    double window = 1.5;
    int cnt = 1;

    if (h <= 0 || bounce <= 0 || bounce >= 1 || window >= h) {
        cnt = -1;
    } else {
        while (h* bounce> window) {
            h *= bounce;
            cnt += 2;
        }
        System.out.println(cnt);
    }

}
