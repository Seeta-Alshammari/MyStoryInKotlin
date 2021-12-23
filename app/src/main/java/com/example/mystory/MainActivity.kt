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
        updateEmailInHeader(email) //دالة لتمرير الايميل
        drawerClicks()//دالة التحكم بعملية الضغط على الزر
        openAddStoryActivity()
        displayStories()
    }

    private fun updateEmailInHeader(email: String?) {
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
            val i = Intent(this,AddStoryActivity::class.java)
            startActivity(i)
        }
    }
    private fun displayStories() {
        val storiesArray = ArrayList<Story>()
        storiesArray.add(Story("قصتي الاولى _ Kotlin", " الاسبوع الاول في معسكر كوتلن ", " الاسبوع الاول:\n" +
                "\n" +
                "في بداية الاسبوع الاول تعرفنا على اكاديمية طويق وكيف نحقق اكبر استفادة من هذا المعسكر\n" +
                "حيث تم توضيح ماهو معسكر كوتلن وماهي الفائده منه وماهو هو المخرج النهائي بعد انتهاء المعسكر .\n" +
                "\n" +
                "\n" +
                "بعد ذلك تعرفنا على خطه المعسكر ،طبعاً كانت خطه جدًا منظمه وواضحه تركز على اهم المفاهيم والعناصر الاساسيه التي يجب ان يلم بها الطالب في نهاية المعسكر .\n" +
                "\n" +
                "الشي المميز في هذا المعسكر كان انه لا يحتاج الى اي معرفة سابقه بالبرمجة مع انه كان لدي خلفيه برمجية بسيطه لكنه كان شيئاً مميزًا يخدم جميع الطلاب حتى وان كان ليس لديهم اي معلومات عن البرمجة ، حيث ان المعسكر لم يكن مقتصرًا على الطلاب اصحاب تخصصات الحاسب او البرمجة بل كان مفتوح للجميع .\n" +
                "\n" +
                "بعد ذلك تعرفنا على لغة كوتلن ومميزاتها وتطرقنا لبعض الدورس والتمارين البسيطة كبداية في تعلم هذه اللغة الممتعه .\n" +
                "\n" +
                "\n" +
                "طبعًا في الاسبوع الاول تم تطبيق التمارين على برنامج محاكي يشبه بيئة اندرويد استديو بما اننا لم نستطيع جميعاً تحميل البرنامج والعمل عليه ، حيث واجه بعضنا مشاكل في تثبيته منها مساحه الجهاز كانت لا تساعد على التحميل، كذلك تنزيل الـ SDK طبعًا مشكله واجهت اغلب الطلاب وتم التواصل مع المدرب المسؤول عن المعسكر في المساعده لحل المشكلة.\n" +
                "\n" +
                "كانت لغة سهله الى حد ما مقارنه باللغات الأخرى والاهم فيها اختصار عدد الاسطر بالكود هذا الشي جعلها سهله وبسيطه علينا بإلاضافة الى شروحات المدرب كانت جداً ممتازه وسهله .\n "
            )
        )
        storiesArray.add(Story("قصتي الثانية_ Kotlin ", " الاسبوع الثاني في معسكر كوتلن ", " الاسبوع الثاني :\n" +
                "\n" +
                "في الاسبوع الثاني بدأنا نتعمق في مجال برمجة التطبيق بإستخدام لغة كوتلن والتعرف على أساسيات هذه اللغة وكيفية التعامل معها\n" +
                "\n" +
                "الى ان يتم تحميل برنامج اندرويد استديو كان لابد من التطبيق وحل الواجبات والتمارين على نفس خطة المعسكر لذلك استخدمنا برنامج انتل جي (intellj ) هذا البرنامج يحاكي برنامج اندرويد استديو لتعلم الاساسيات والتدريب على حل التمارين.\n" +
                "\n" +
                "\n" +
                "أيضاً تعرفنا على اهم مفاهيم برمجة التطبيقات بلغة كوتلن منها الجمل الشرطيه ، المتغيرات ، الدوال، المصفوفات وكيفية استخدام كل واحده منها وفائدها وتطبيق بعض التمارين عليها ،وأيضًا تعرفنا على البرمجة كائنية التوجه واهميتها وكيفية استخدامها والمبادئ الاساسية لها ."
            )
        )
        storiesArray.add(Story("قصتي الثالثة  _ Kotlin", " الاسبوع الثالث في معسكر كوتلن ", "الاسبوع الثالث:\n" +
                "\n" +
                "\n" +
                "في الاسبوع الثالث بدأنا فعليًا في إستخدام اندرويد استديو بعد حل جميع المشاكل اللي واجهت جميع الطلاب فيه ، بدأ العمل الفعلي بأنشاء اول تطبيق برمجي بلغة كوتلن خاص بكل طالب وطالبه .\n" +
                "\n" +
                "ثم تعرفنا على واجهة هذه البرنامج ومايحتوي من خصائص وكيفية استخدامه والاشياء المهمه التي نحتاجها في العمل عليه منها انشاء محاكي داخل بيئة العمل حتى نستطيع رؤية نتيجه عملنا على هذا المحاكي كأنه هاتف بنظام اندرويد\n" +
                "\n" +
                "بعد ذلك قمنا بتصميم اول واجهه لنا في هذا المعسكر ورؤية المخرج النهائي منها ، حيث كانت تجربه جدًا ممتعة وحماسية في تعلم المزيد والاستمرار في المعسكر ؛لانه التصميم الظاهري وانك ترا شاشة تكتمل امامك يعطي مزيدًا من الحماس والاستمرار عن كونه كتابه اكواد ولا ترا المخرج لها بالاضافة الى الابداع في مجال التصميم والتنسيق للواجهات حيث كل مطور له لمسته الخاصه في تصميم اي واجهه .\n" +
                "\n" +
                "\n" +
                "قمنا بتصميم واجهة تسجيل الدخول والتفاعل معها واستخدام الحاويات وكيفية أختيار الحاوية المناسبة حسب الغرض من الواجهه او التطبيق\n" +
                "\n" +
                "أيضًا تعرفنا على اهم العناصر في برنامج اندرويد استديو واهميتها وطريقه استخدامها منها Logcat و Debug والفائدة من إستخدامها أثناء عمل المشروع .\n" +
                "\n" +
                "كذلك تعرفنا على طريقه عرض البيانات الكبيرة بحيث نعرضها في View Recycling (ListView)وكيفية التفاعل معها واستخدامها بالطريقة الصحيحة.\n" +
                "\n" +
                "\n" +
                "في نهاية الاسبوع الثالث اصبح لدينا معرفه بسيطة نوعاً ما في عالم تطوير تطبيقات الاندرويد بإستخدام لغة كوتلن وكيفية انشاء الواجهات حسب المطلوب والتفاعل مع هذه الواجهات وحل المشكلات التي تواجهنا اثناء عمل المشروع ، لكنها كانت بداية جداً رائعة للانطلاق نحو الاحترافية في تطوير تطبيقات الاندرويد. "
            )
        )

        storiesArray.add(Story("قصتي الرابعة _ Kotlin", " الاسبوع الرابع في معسكر كوتلن ", "\n" +
                "الاسبوع الرابع:\n" +
                "\n" +
                "في الاسبوع الرابع تعرفنا على الـ Activity والمقصود بها وطريقة تصميمها وكيفية الانتقال من واجهة الى اخرى\n" +
                "\n" +
                "طبعًا وجدت صعوبه في بداية تصميم الواجهات من حيث ضبط المقاسات وجعل التصميم مناسب للشاشة الهاتف و يعرض على جميع الاصدارات بطريقة ملائمة مع كل جهاز واصداره ،لكن مع الممارسه والتعرف على كل عنصر خاص بالمقاسات وطريقة استخدامه اصبحنا قادرين على ضبط المقاسات واظهار الواجهات بشكل متناسق ومناسب .\n" +
                "\n" +
                "تعرفنا على الانتقال وكيف يتم الانتقال من شاشة الى شاشة اخرى وكذلك الانتقال من تطبيقنا الى تطبيق اخر\n" +
                "\n" +
                "تطرقنا الى الـ Fragments وفائدتها في عمل التطبيق ، حيث تعمل على تقسيم الشاشة الى عدة اجزاء كل جزء يؤدي مهمة معينه ، تعتبر جزء من الـActivity ولا يمكن اظهارها بدون الـActivity.\n" +
                "\n" +
                "تعرفنا على الـ Bottom Navigationv حيث يعتبر من اهم العناصر داخل تطبيقات الاندرويد واكثرها شيوعاً ، وكذلك قمنا بإنشاء الايقونات واختيار كل ايقونه حسب الغرض من اسخدامها .\n" +
                "\n" +
                "بدء الظهور الفعلي لمعالم التطبيق من خلال إضافة عناصر تم مشاهدتها في كثير من التطبيقات والتفاعل معها مثل عنصر الـ Bottom Navigation ،هذا العنصر نشاهده بشكل كبير جدًا في اغلب التطبيقات لكن لا نعرف كيف يتم أضافته وإضافة الايقونات الخاصه به وبرمجته للتفاعل معه\n" +
                "لكن في نهاية الاسبوع الرابع قمنا بعمل كل ذلك وتجاوزنا جميع العقبات التي واجهتنا ،\n" +
                "واصبحنا قادرين على فهم هذا العنصر والتعامل معه واستخدامه بالطريقة الصحيحة.\n "))
        storiesArray.add(Story("قصتي الخامسة _ Kotlin", " الاسبوع الخامس في معسكر كوتلن ", " الأسبوع الخامس:\n" +
                "\n" +
                "في الاسبوع الخامس ظهرت لنا مفاهيم جديدة ومهمه في عالم تطوير التطبيقات من اهمها مفهوم\n" +
                "الـ Github حيث تم التعرف عليه وعلى اهميته\n" +
                "\n" +
                "\n" +
                "يتعبر الـ GitHub من أهم المواقع بالنسبه لمطوري التطبيقات والبرمجيات بشكل عام ، حيث يوفر عليهم كثير من الوقت والجهد ويسمح لهم العمل كفريق بحيث لا يتعارض عمل اعضاء الفريق فيما بينهم عند تطوير التطبيق\n" +
                "\n" +
                "فكرته تقوم على إنشاء مستودع خاص بالتطبيق وكل عضو يقوم بتحمل اخر نسخه معدله من التطبيق ويتم التعديل عليها ورفعها مره اخر على GitHub حتى يستطيع باقي الأعضاء الحصول على اخر نسخه محدثه ومعدله من التطبيق.\n" +
                "\n" +
                "\n" +
                "بعد ذلك تعرفنا على مفهوم الـ Toast و الـ Snackbar والفائدة منهما وطريقة إستخدامهما في المشاريع واختيار المناسب منهما حسب الغرض والحاجه.\n" +
                "\n" +
                "\n" +
                "أيضاً تطرقنا الى مفهوم الدوال بشكل موسع والتعرف على انواعها وطريقه كتابه كل نوع وإستخدامه والمدخلات وانواعها وامثله وتمارين على جميع هذه المفاهيم.\n" +
                "\n" +
                "\n" +
                "في اليوم الاخير من الاسبوع الخامس تعرفنا على\n" +
                "الـ Navigation Drawer وفائدته في اظهار القائمة الجانبيه الخاصة بالتطبيق واهم العناصر التي يحتوي عليها والتفاعل معه.\n" +
                "\n" +
                "في نهاية الاسبوع الخامس اصبح لدينا ثريد من المعلومات والمفاهيم المتعلقه بهذه اللغه والتعامل معها ولاحظنا تطور ملحوظ في مستوى المعرفة لدينا بهذه اللغة وكيفية استخدامها مقارنة في بداية المعسكر حيث لم يكن لدينا اي خلفيه او معلومة عنها ،لذلك يعتبر إنجاز بالنسبه لنا الوصول الى هذه المرحله ."))
        storiesArray.add(Story("قصتي السادسة _ Kotlin", " الاسبوع السادس في معسكر كوتلن ", "الاسبوع السادس:\n" +
                "\n" +
                "في الاسبوع السادس بدأنا في المشروع النهائي المطلوب تنفيذه في نهاية هذا المعسكر\n" +
                "\n" +
                "حيث يتضمن هذا المشروع تطبيق جميع المفاهيم والمعلومات التي تم دراستها خلال خمسة اسابيع متتالية .\n" +
                "\n" +
                "في البداية تعرفنا على مقدمة عن هذا المشروع النهائي حيث انه عبارة عن قصة متسلسلة يروي فيها كل طالب وطالبه ما تعلمه في هذا المعسكر وماهي العقبات اللي واجهتنا في كل اسبوع وكيف تم التغلب عليها وكذلك توضيح المفاهيم التي تمت دراستها خلال المعسكر.\n" +
                "\n" +
                "\n" +
                "قمنا بتسمية التطبيق وتغيير ايقونة التطبيق واضافة شاشة أنتظار قبل بدء تسجيل الدخول\n" +
                "\n" +
                "بعد ذلك قمنا برفع التطبيق على Github\n" +
                "\n" +
                "أيضاً أضفنا شاشة تسجيل الدخول حيث تسمح للمستخدم تسجيل الدخول للتطبيق بإسم مستخدم وكلمة مرور خاصه به\n" +
                "يستطيع من خلالها تصفح التطبيق وعرض القصص وكذلك إضافة قصة جديده .\n" +
                "\n" +
                "طبعاً الانتهاء من كل مره نقوم بعمل push لأخر التعديلات على GitHub حتى نتفادى حدوث اي مشاكل مستقبلًا وفي حال حدوثها يتم الرجوع الى كود المصدر واكتشاف الخطأ وكذلك نسمح للمطورين في اعضاء الفريق بالحصول على النسخه الاخيره بعد التعديلات .\n "))
        storiesArray.add(Story("قصتي السابعة _ Kotlin", " الاسبوع السابع في معسكر كوتلن ", " الاسبوع السابع :\n" +
                "\n" +
                "\n" +
                "هذا الاسبوع هو تكمله للمشروع النهائي حيث بدأنا بإضافة عناصر وتنسيقات جديده تناسب الشكل النهائي للمشروع\n" +
                "\n" +
                "بدأنا فعلياً بالعمل على طريقة عرض القصص والشكل المناسب لعرضها من خلال استخدام RecyclerView و إنشاء Custom Layout و Custom Class له\n" +
                "\n" +
                "\n" +
                "قمنا إضافة رز لكتابة قصة جديده بحيث عند الضغط عليه يستطيع المستخدم ان يكتب القصه الجديده الخاصه به.\n" +
                "\n" +
                "بعد ذلك تم كتابة المنطق البرمجي الخاص بالتفاعل مع هذه القصص من عرضها وكتابه قصص جديده وعند الضغط على احد القصص يتم عرض تفاصيل هذه القصه بالكامل.\n" +
                "\n" +
                "في نهاية الأسبوع اصبح لدينا التطبيق شبة مكتمل\n" +
                "ويحتوي على مجموعة من الواجهات والشاشات منها شاشة تسجيل الدخول وشاشة عرض القصص وشاشة عرض تفاصيل القصة ..الخ\n" +
                "التي يستطيع المستخدم التفاعل معها وعرضها بدون اي مشاكل."))
        storiesArray.add(Story("قصتي الثامنة _ Kotlin", " الاسبوع الثامن _الأخير في المعسكر  ", "الاسبوع الثامن _ الاخير :\n" +
                "\n" +
                "في هذا الاسبوع تم تصميم اخر واجهة في التطبيق وهي واجهة إضافة قصة جديده وكتابه المنطق البرمجي الخاص بالتفاعل معها .\n" +
                "\n" +
                "الى هنا بفضل الله عزوجل تم إكمال المشروع النهائي لمعسكر تطوير تطبيقات الاندرويد بإستخدام لغة كوتلن واصبح لدينا القدره على برمجة تطبيق بسيط متكامل يحتوي على جميع المفاهيم التي تعلمناها في هذا المعسكر.\n" +
                "\n" +
                "حتى وان كان تطبيق بسيط ومبتدئ لكنه بأذن الله نقطه الانطلاق نحو الاحترافيه في تطوير تطبيقات الاندرويد وتحقيق اقصى استفادة وممارسه لجميع المفاهيم حيث لا يمكن ان ترسخ معلومات البرمجه دون الممارسه والتعامل الفعلي معها .\n" +
                "\n" +
                "بعد ذلك بدأنا في التجهيز لنشر تطبيقنا الخاص على متجر Google Play والتعرف على هذا المتجر الخاص بالتطبيقات والمنتجات الالكترونية التي يتم عرضها فيه لتحميلها والاستفادة منها.\n" +
                "\n" +
                "\n" +
                "تعرفنا على المتطلبات الخاصه بنشر التطبيق وقمنا بتجهيز هذه المتطلبات منها تحديد رقم الاصدار إنشاء Keystore خاص بالتطبيق وكذلك\n" +
                "انشاء Signed APK/AAB وإدخال معلومات التطبيق على المتجر ورفع الأيقونه الخاصه بالتطبيق وبعض صور التطبيق لتوضيح واجهات التطبيق للمستخدمين.\n" +
                "\n" +
                "\n" +
                "في الخطوه الأخيره في هذا المعسكر تم بحمد الله عزوجل نشر التطبيق على متجر google play حيث يستطيع المستخدمين تحمليه والاستفادة منه .\n "))
        storiesArray.add(Story("النهاية  _ Kotlin", "  في ختام معسكر طويق 1000_عن بعد  ", "كان إنجازاً عظيماً بالنسبة لنا كوننا بدأنا من الصفر وليس لدينا اي معرفة سابقة في لغة كوتلن و الآن اصبح لدينا تطبيق متكامل خالي من المشاكل تم نشره على المتجر يستطيع اي مستخدم تحمليه والاطلاع عليه والاستفادة منه في مدة قصيرة جدًا لا تتجاوز الشهرين ، فهذا بحد ذاته يتعبر إنجاز نفتخر به ونشكر جميع القائمين على هذا المعسكر والشكر لله عزوجل ثم للمهندس : أيمن قائد -\n" +
                "المدرب المسؤول عن معسكر تطوير تطبيقات الاندرويد بلغة كوتلن ، حيث كان له الفضل الكبير في تعلم هذه اللغة وتحقيق أقصى استفادة من هذا المعسكر من خلال استثمار جميع المعلومات والمفاهيم التي تم التعرف بعمل تطبيق متكامل يشمل جميع هذه المفاهيم ، كذلك حرصه على توصيل المعلومه بطريقة سهله وبسيطه وتجاوبه مع جميع المتدربين وحل المشاكل التي تواجههم وحرصه على المضي قدماً في هذا المعسكر لتحقيق الفائدة المرجوه منه . فله جزيل الشكر والتقدير منّا جميعاً .\n "))


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

object AddStoryActivity {

}



