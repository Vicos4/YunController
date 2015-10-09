package com.example.nvlad.remoteforyun;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class MainActivity extends Activity
{

    RelativeLayout layout_joystick;
    ImageView image_joystick, image_border;
    TextView textView1, textView2, textView3, textView4, textView5;

    JoyStickClass js;
    boolean positionChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
        textView5 = (TextView)findViewById(R.id.textView5);

        layout_joystick = (RelativeLayout)findViewById(R.id.layout_joystick);

        js = new JoyStickClass(getApplicationContext(), layout_joystick, R.drawable.tank12);
        js.setStickSize(150, 150);
        js.setLayoutSize(500, 500);
        js.setLayoutAlpha(150);
        js.setStickAlpha(100);
        js.setOffset(90);
        js.setMinimumDistance(50);



        layout_joystick.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View arg0, MotionEvent arg1) {
                js.drawStick(arg1);
                if(arg1.getAction() == MotionEvent.ACTION_DOWN
                        || arg1.getAction() == MotionEvent.ACTION_MOVE) {
                    textView1.setText("X : " + String.valueOf(js.getX()));
                    textView2.setText("Y : " + String.valueOf(js.getY()));
                    textView3.setText("Angle : " + String.valueOf(js.getAngle()));
                    textView4.setText("Distance : " + String.valueOf(js.getDistance()));

                    int direction = js.get8Direction();
                    //region UP
                    if(direction == JoyStickClass.STICK_UP_1)
                    {
                        Forward("http://192.168.240.1/arduino/digital/13/11");
                        textView5.setText("Direction : Up");
                        System.out.println("Forward Speed 1");
                    }
                    else if(direction == JoyStickClass.STICK_UP_2)
                    {
                        Forward("http://192.168.240.1/arduino/digital/13/12");
                        textView5.setText("Direction : Up");
                        System.out.println("Forward Speed 2");
                    }
                    else if(direction == JoyStickClass.STICK_UP_3)
                    {
                        Forward("http://192.168.240.1/arduino/digital/13/13");
                        textView5.setText("Direction : Up");
                        System.out.println("Forward Speed 3");
                    }
                    //endregion
                    //region UPRIGHT
                    else if(direction == JoyStickClass.STICK_UPRIGHT_1)
                    {
                        UpRight("http://192.168.240.1/arduino/digital/13/21");
                        textView5.setText("Direction : Up Right");
                        System.out.println("Forward Right Speed 1");
                    }
                    else if(direction == JoyStickClass.STICK_UPRIGHT_2)
                    {
                        UpRight("http://192.168.240.1/arduino/digital/13/22");
                        textView5.setText("Direction : Up Right");
                        System.out.println("Forward Right Speed 2");
                    }
                    else if(direction == JoyStickClass.STICK_UPRIGHT_3)
                    {
                        UpRight("http://192.168.240.1/arduino/digital/13/23");
                        textView5.setText("Direction : Up Right");
                        System.out.println("Forward Right Speed 3");
                    }
                    //endregion
                    //region RIGHT
                    else if(direction == JoyStickClass.STICK_RIGHT_1)
                    {
                        Right("http://192.168.240.1/arduino/digital/13/31");
                        textView5.setText("Direction : Right");
                        System.out.println("Right Speed 1");
                    }
                    else if(direction == JoyStickClass.STICK_RIGHT_2)
                    {
                        Right("http://192.168.240.1/arduino/digital/13/32");
                        textView5.setText("Direction : Right");
                        System.out.println("Right Speed 2");
                    }
                    else if(direction == JoyStickClass.STICK_RIGHT_3)
                    {
                        Right("http://192.168.240.1/arduino/digital/13/33");
                        textView5.setText("Direction : Right");
                        System.out.println("Right Speed 3");
                    }
                    //endregion
                    //region DOWNRIGHT
                    else if(direction == JoyStickClass.STICK_DOWNRIGHT_1)
                    {
                        DownRight("http://192.168.240.1/arduino/digital/13/41");
                        textView5.setText("Direction : Down Right");
                        System.out.println("Down Right Speed 1");
                    }
                    else if(direction == JoyStickClass.STICK_RIGHT_2)
                    {
                        DownRight("http://192.168.240.1/arduino/digital/13/42");
                        textView5.setText("Direction : Down Right");
                        System.out.println("Down Right Speed 2");
                    }
                    else if(direction == JoyStickClass.STICK_RIGHT_3)
                    {
                        DownRight("http://192.168.240.1/arduino/digital/13/43");
                        textView5.setText("Direction : Down Right");
                        System.out.println("Down Right Speed 3");
                    }
                    //endregion
                    //region DOWN
                    else if(direction == JoyStickClass.STICK_DOWN_1)
                    {
                        Back("http://192.168.240.1/arduino/digital/13/51");
                        textView5.setText("Direction : Back");
                        System.out.println("Back Speed 1");
                    }
                    else if(direction == JoyStickClass.STICK_DOWN_2)
                    {
                        Back("http://192.168.240.1/arduino/digital/13/52");
                        textView5.setText("Direction : Back");
                        System.out.println("Back Speed 2");
                    }
                    else if(direction == JoyStickClass.STICK_DOWN_3)
                    {
                        Back("http://192.168.240.1/arduino/digital/13/53");
                        textView5.setText("Direction : Back");
                        System.out.println("Back Speed 3");
                    }
                    //endregion
                    //region DOWNLEFT
                    else if(direction == JoyStickClass.STICK_DOWNLEFT_1)
                    {
                        DownLeft("http://192.168.240.1/arduino/digital/13/61");
                        textView5.setText("Direction : Down Left");
                        System.out.println("Down Left Speed 1");
                    }
                    else if(direction == JoyStickClass.STICK_DOWNLEFT_2)
                    {
                        DownLeft("http://192.168.240.1/arduino/digital/13/62");
                        textView5.setText("Direction : Down Left");
                        System.out.println("Down Left Speed 2");
                    }
                    else if(direction == JoyStickClass.STICK_DOWNLEFT_3)
                    {
                        DownLeft("http://192.168.240.1/arduino/digital/13/63");
                        textView5.setText("Direction : Down Left");
                        System.out.println("Down Left Speed 3");
                    }
                    //endregion
                    //region LEFT
                    else if(direction == JoyStickClass.STICK_LEFT_1)
                    {
                        Left("http://192.168.240.1/arduino/digital/13/71");
                        textView5.setText("Direction : Left");
                        System.out.println("Left Speed 1");
                    }
                    else if(direction == JoyStickClass.STICK_LEFT_2)
                    {
                        Left("http://192.168.240.1/arduino/digital/13/72");
                        textView5.setText("Direction : Left");
                        System.out.println("Left Speed 2");
                    }
                    else if(direction == JoyStickClass.STICK_LEFT_3)
                    {
                        Left("http://192.168.240.1/arduino/digital/13/73");
                        textView5.setText("Direction : Left");
                        System.out.println("Left Speed 3");
                    }
                    //endregion
                    //region UPLEFT
                    else if(direction == JoyStickClass.STICK_UPLEFT_1)
                    {
                        UpLeft("http://192.168.240.1/arduino/digital/13/81");
                        textView5.setText("Direction : Up Left");
                        System.out.println("Up Left Speed 1");
                    }
                    else if(direction == JoyStickClass.STICK_UPLEFT_2)
                    {
                        UpLeft("http://192.168.240.1/arduino/digital/13/82");
                        textView5.setText("Direction : Up Left");
                        System.out.println("Up Left Speed 2");
                    }
                    else if(direction == JoyStickClass.STICK_UPLEFT_3)
                    {
                        UpLeft("http://192.168.240.1/arduino/digital/13/83");
                        textView5.setText("Direction : Up Left");
                        System.out.println("Up Left Speed 3");
                    }
                    //endregion
                    //region STOP
                    else if(direction == JoyStickClass.STICK_NONE)
                    {
                        new Stop().execute("http://192.168.240.1/arduino/digital/13/0");
                        Stop();
                        System.out.println("Stop");
                        textView5.setText("Direction : Center");
                    }
                    //endregion
//                    else if(direction == JoyStickClass.STICK_UPRIGHT_1)
//                    {
//                        System.out.println("Forward Right");
//                        //new Forward().execute("http://192.168.240.1/arduino/digital/13/500");
//                        textView5.setText("Direction : Up Right");
//                    } else if(direction == JoyStickClass.STICK_RIGHT)
//                    {
//                        //new Right().execute("http://192.168.240.1/arduino/digital/13/1");
//                        Right();
//                        System.out.println("Right");
//                        textView5.setText("Direction : Right");
//                    } else if(direction == JoyStickClass.STICK_DOWNRIGHT)
//                    {
//                        System.out.println("Down Right");
//                        //new Forward().execute("http://192.168.240.1/arduino/digital/13/500");
//                        textView5.setText("Direction : Down Right");
//                    } else if(direction == JoyStickClass.STICK_DOWN)
//                    {
//                        //new Back().execute("http://192.168.240.1/arduino/digital/13/1500");
//                        Back();
//                        textView5.setText("Direction : Down");
//                        System.out.println("Down");
//                    } else if(direction == JoyStickClass.STICK_DOWNLEFT)
//                    {
//                        //new Forward().execute("http://192.168.240.1/arduino/digital/13/500");
//                        textView5.setText("Direction : Down Left");
//                        System.out.println("Down Left");
//                    } else if(direction == JoyStickClass.STICK_LEFT)
//                    {
//                        //new Left().execute("http://192.168.240.1/arduino/digital/13/2");
//                        Left();
//                        System.out.println("Left");
//                        textView5.setText("Direction : Left");
//                    } else if(direction == JoyStickClass.STICK_UPLEFT)
//                    {
//                        //new Forward().execute("http://192.168.240.1/arduino/digital/13/500");
//                        textView5.setText("Direction : Up Left");
//                        System.out.println("Up Left");
//                    } else if(direction == JoyStickClass.STICK_NONE)
//                    {
//                        //new Stop().execute("http://192.168.240.1/arduino/digital/13/0");
//                        Stop();
//                        System.out.println("Stop");
//                        textView5.setText("Direction : Center");
//                    }
                } else if(arg1.getAction() == MotionEvent.ACTION_UP)
                {
                    textView1.setText("X :");
                    textView2.setText("Y :");
                    textView3.setText("Angle :");
                    textView4.setText("Distance :");
                    textView5.setText("Direction :");
                }
                return true;
            }
        });
    }





//    public void buttonForward(View v)
//    {
//        findViewById(R.id.buttonTop).setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                new Forward().execute("http://192.168.240.1/arduino/digital/13/500");
//            }
//        });
//    }
//    public void buttonBack(View v)
//    {
//        findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener()
//        {
//            public void onClick(View v)
//            {
//                new Back().execute("http://192.168.240.1/arduino/digital/13/1500");
//            }
//        });
//    }
//    public void buttonStop(View v)
//    {
//        findViewById(R.id.buttonStop).setOnClickListener(new View.OnClickListener()
//        {
//            public void onClick(View v)
//            {
//                new Stop().execute("http://192.168.240.1/arduino/digital/13/0");
//            }
//        });
//    }
//    public void buttonLeft(View v)
//    {
//        findViewById(R.id.buttonLeft).setOnClickListener(new View.OnClickListener()
//        {
//            public void onClick(View v)
//            {
//                new Left().execute("http://192.168.240.1/arduino/digital/13/2");
//            }
//        });
//    }
//    public void buttonRight(View v)
//    {
//        findViewById(R.id.buttonRight).setOnClickListener(new View.OnClickListener()
//        {
//            public void onClick(View v)
//            {
//                new Right().execute("http://192.168.240.1/arduino/digital/13/1");
//            }
//        });
//    }

public void Forward(String url)
{


// Request a string response
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    // Result handling
                    //System.out.println(response.substring(0,10000));

                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

            // Error handling
            System.out.println("Something went wrong!");
            error.printStackTrace();

        }
    });

// Add the request to the queue
    Volley.newRequestQueue(this).add(stringRequest);
    //Volley.newRequestQueue(this).cancelAll(stringRequest);
}
    public void DownLeft(String url)
    {


// Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Result handling
                        //System.out.println(response.substring(0,10000));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();

            }
        });

// Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);
        //Volley.newRequestQueue(this).cancelAll(stringRequest);
    }
    public void DownRight(String url)
    {


// Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Result handling
                        //System.out.println(response.substring(0,10000));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();

            }
        });

// Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);
        //Volley.newRequestQueue(this).cancelAll(stringRequest);
    }
    public void UpLeft(String url)
    {


// Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Result handling
                        //System.out.println(response.substring(0,10000));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();

            }
        });

// Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);
        //Volley.newRequestQueue(this).cancelAll(stringRequest);
    }
    public void UpRight(String url)
    {


// Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Result handling
                        //System.out.println(response.substring(0,10000));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();

            }
        });

// Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);
        //Volley.newRequestQueue(this).cancelAll(stringRequest);
    }
    public void Right(String url)
    {
//        String url = null;
//        if (js.getDistance() <= 80)
//        {
//            url = "http://192.168.240.1/arduino/digital/13/11";
//            System.out.println("First Speed");
//        }else if (js.getDistance() > 80 && js.getDistance() <= 160)
//        {
//            url = "http://192.168.240.1/arduino/digital/13/12";
//            System.out.println("Second Speed");
//        }else if (js.getDistance() > 160)
//        {
//            url = "http://192.168.240.1/arduino/digital/13/13";
//            System.out.println("Third Speed");
//        }
        //String url = "http://bing.com";

// Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Result handling
                       // System.out.println(response.substring(0,10000));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();

            }
        });

// Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);
        //Volley.newRequestQueue(this).cancelAll(stringRequest);
    }
    public void Left(String url)
    {
//        String url = null;
//        if (js.getDistance() <= 80)
//        {
//            url = "http://192.168.240.1/arduino/digital/13/21";
//            System.out.println("First Speed");
//        }else if (js.getDistance() > 80 && js.getDistance() <= 160)
//        {
//            url = "http://192.168.240.1/arduino/digital/13/22";
//            System.out.println("Second Speed");
//        }else if (js.getDistance() > 160)
//        {
//            url = "http://192.168.240.1/arduino/digital/13/23";
//            System.out.println("Third Speed");
//        }

// Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Result handling
                        //System.out.println(response.substring(0,100));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();

            }
        });

// Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);
        //Volley.newRequestQueue(this).cancelAll(stringRequest);
    }
    public void Back(String url)
    {
//        String url = null;
//        if (js.getDistance() <= 80)
//        {
//            url = "http://192.168.240.1/arduino/digital/13/1500";
//            System.out.println("First Speed");
//        }else if (js.getDistance() > 80 && js.getDistance() <= 160)
//        {
//            url = "http://192.168.240.1/arduino/digital/13/1530";
//            System.out.println("Second Speed");
//        }else if (js.getDistance() > 160)
//        {
//            url = "http://192.168.240.1/arduino/digital/13/1560";
//            System.out.println("Third Speed");
//        }

// Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Result handling
                        //System.out.println(response.substring(0,100));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();

            }
        });

// Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);
       // Volley.newRequestQueue(this).cancelAll(stringRequest);
    }
    public void Stop()
    {
        String url = "http://192.168.240.1/arduino/digital/13/0";

// Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Result handling
                       // System.out.println(response.substring(0,100));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();

            }
        });

// Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);
      //  Volley.newRequestQueue(this).cancelAll(stringRequest);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

















