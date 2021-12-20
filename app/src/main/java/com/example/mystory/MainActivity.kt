package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
class AddStoryActivity

class MainActivity : AppCompatActivity() {
    private var textViewEmail: TextView? = null
    private var drawerLayout: DrawerLayout? = null
    private var toolBarView: Toolbar? = null
    private var navigationView: NavigationView? = null
    private var recyclerView: RecyclerView? = null
    private var buttonAddStory: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email =
            intent.getStringExtra("email")//لنقل بيانات الايميل الى الواجهه التالية (ينقل الايميل 1)
        connectViews()//يعمل الربط2
        textViewEmail?.text = email//يضع الايميل في :3textview
        setSupportActionBar(toolBarView)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupDrawer()
        updateEmailInHeader(email!!) //دالة لتمرير الايميل
        drawerClicks()//دالة التحكم بعملية الضغط على الزر
        openAddStoryActivity()
        displayStories()
    }

    private fun updateEmailInHeader(email: String) {
        val headerView =
            navigationView?.getHeaderView(0)//دالة تمريرال headerView,صفرلأن عندنا  headerView  واحد فقط
        val textViewEmail =
            headerView?.findViewById<TextView>(R.id.tvEmail)//سحب الايميل من ال textView
        textViewEmail?.text = email //اسقبال الايميل
    }

    private fun setupDrawer() {
        val toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)//class
        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout?.openDrawer(GravityCompat.START)
                true
            }
            else -> true
        }
    }

    private fun connectViews() {
        textViewEmail = findViewById(R.id.tvEmail)
        drawerLayout = findViewById(R.id.drawer)
        toolBarView = findViewById(R.id.toolbar)
        navigationView = findViewById(R.id.navigation)
        recyclerView = findViewById(R.id.storiesRecyclerView)
        buttonAddStory = findViewById(R.id.btnAddStory)
    }

    private fun drawerClicks() {
        navigationView?.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    drawerLayout?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.logout -> {

                    finish()
                    val i = Intent(this, LoginActivity::class.java)
                    startActivity(i)

                    true
                }
                else -> true
            }
        }
    }

    private fun openAddStoryActivity() {
        buttonAddStory?.setOnClickListener {
            val i = Intent(this, AddStoryActivity::class.java)
            startActivity(i)
        }
    }

    private fun displayStories() {
        val storiesArray = ArrayList<Story>()
        storiesArray.add(Story("قصتي الاولى _ Kotlin", " الاسبوع الاول في معسكر كوتلن ", "تحديات وعقبات الاسبوع الاول في المعسكر،بالاضافة الى ماذا تعلمت في هذا الاسبوع تحديات وعقبات الاسبوع الاول في المعسكر،بالاضافة الى ماذا تعلمت في هذا الاسبوع تحديات وعقبات الاسبوع الاول في المعسكر،بالاضافة الى ماذا تعلمت في هذا الاسبوع تحديات وعقبات الاسبوع الاول في المعسكر،بالاضافة الى ماذا تعلمت في هذا الاسبوع تحديات وعقبات الاسبوع الاول في المعسكر،بالاضافة الى ماذا تعلمت في هذا الاسبوع تحديات وعقبات الاسبوع الاول في المعسكر،بالاضافة الى ماذا تعلمت في هذا الاسبوع تحديات وعقبات الاسبوع الاول في المعسكر،بالاضافة الى ماذا تعلمت في هذا الاسبوع تحديات وعقبات الاسبوع الاول في المعسكر،بالاضافة الى ماذا تعلمت في هذا الاسبوع تحديات وعقبات الاسبوع الاول في المعسكر،بالاضافة الى ماذا تعلمت في هذا الاسبوع "
            )
        )
        storiesArray.add(Story("قصتي الثانية_ Kotlin ", " الاسبوع الثاني في معسكر كوتلن ", "تحديات وعقبات الاسبوع الثاني في المعسكر،بالاضافة الى ماذا تعلمت في هذا الاسبوع "
            )
        )
        storiesArray.add(Story("قصتي الثالثة  _ Kotlin", " الاسبوع الثالث في معسكر كوتلن ", "تحديات وعقبات الاسبوع الثالث في المعسكر،بالاضافة الى ماذا تعلمت في هذا الاسبوع  "
            )
        )

        val customAdapter = CustomAdapter(storiesArray, this)
        recyclerView?.adapter = customAdapter

        if (intent.getStringExtra("title") != null) {
            val title = intent.getStringExtra("title")
            val subTitle = intent.getStringExtra("subtitle")
            val desc = intent.getStringExtra("desc")
            val newStory = Story(title!!, subTitle!!, desc!!)
            storiesArray.add(newStory)
            customAdapter.notifyDataSetChanged()
        }
    }
}



