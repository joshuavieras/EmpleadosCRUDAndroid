package cr.ac.menufragment
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

//lateinit dice que se inicializa despues
lateinit var drawerLayout : DrawerLayout


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)

        var toggle=ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.nav_drawer_open,R.string.nav_drawer_close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        var navigationView:NavigationView=findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragment:Fragment
        var titulo:Int
        when(item.itemId){
            R.id.nav_camera->{
                fragment=CamaraFragment.newInstance("Camara")
                titulo=R.string.camara
            }
            R.id.nav_manage->{
                fragment=SettingsFragment()
                titulo=R.string.manage
            }
            R.id.nav_gallery->{
                fragment=ScrollingFragment()
                titulo=R.string.gallery
            }
            else ->{
                fragment=HomeFragment.newInstance("Home")
                titulo=R.string.HomeFragment
            }
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.home_content, fragment)
            .commit()
        setTitle(titulo)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}