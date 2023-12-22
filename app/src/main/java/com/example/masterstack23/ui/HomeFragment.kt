package com.example.masterstack23.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.masterstack23.R
import com.example.masterstack23.adapter.BlogAdapter
import com.example.masterstack23.data.BlogData
import com.example.masterstack23.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

//    val mongoClient = MongoClient("localhost", 27017)
//    val database = mongoClient.getDatabase("DermiCheck")
//    val collection = database.getCollection("blogInfo")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bloglist=ArrayList<BlogData>()

//        val cursor = collection.find()
//
//        for(document in cursor) {
//            println(document.toJson())
//            println("\n\n\n\n\n")
//        }

        bloglist.add(
            BlogData(
                R.drawable.covid_hairloss,"COVID-19 continues to affect hair loss","Many patients experienced significant hair loss following COVID-19 infection, according to a case series published in the Journal of Drugs and Dermatology.\n\n" +
                        "The novel coronavirus disease (COVID-19) is caused by severe acute respiratory syndrome coronavirus 2 and primarily affects the epithelium of the airways.\n\n" +
                        "Hair loss has emerged as a frequent noted side effect of infection with COVID-19 and has been observed in many patients who have recovered from a documented COVID-19 illness, the authors continued.\n","A retrospective study was conducted evaluating the prevalence of hair loss in patients who had recovered from COVID-19.\n\n" +
                        "Of 62 patients with hair loss, histological evaluations of hair samples from 48 had telogen effluvium, 12 showed evidence of androgenetic alopecia and two showed alopecia areata.\n\n" +
                        "Telogen effluvium is the most commonly seen cutaneous complication following the recovery from COVID-19. This is perhaps due to the physical and emotional stress that accompanies COVID-19. Furthermore, since fever is a common symptom of COVID-19, a few months after having a high fever or recovering from an illness, many people observe noticeable hair loss.\n\n" +
                        "A strong relationship between hair loss and COVID-19 was found in this study, according to the researchers, raising questions regarding the virus’s effect on autoimmune disorders such as alopecia areata.\n\n" +
                        "Regardless of its nature, hair loss seems to be a common finding following recovery from COVID-19 infection and a larger study may be needed to evaluate what can be done to reduce the number of cases of hair loss.\n\n")
        )

        bloglist.add(
            BlogData(R.drawable.fda,"FDA issues warning about over-the-counter skin lightening products","The FDA has issued warning letters to 12 companies for selling over-the-counter skin lightening products containing hydroquinone, according to a press release.\n\n" +
                    "FDA is alerting consumers there are no FDA-approved or otherwise legally marketed OTC skin lightening products.\n","The FDA has issued warning letters to 12 companies for selling over-the-counter skin lightening products containing hydroquinone.\n\n" +
                    "Serious side effects have been reported with these products including skin rashes, facial swelling and skin discoloration, and the FDA is warning the public not to use any OTC skin lightening products.\n\n" +
                    "Hydroquinone is not approved in any OTC products, as its only indication is for Tri-Luma, a prescription product for the short-term treatment of dark spots associated with melasma.\n\n" +
                    "While some of the companies involved have already removed their products from shelves, the FDA plans to take action against those who continue to sell or market these products.\n\n" +
                    "The organization has asked each company to respond within 15 days detailing how these violations to the CARES act are being addressed.\n\n" +
                    "FDA reminds manufacturers and distributors it is their responsibility to comply with all requirements of federal law and FDA regulations, and to ensure their drugs meet federal standards for safety and effectiveness.\n\n")
        )

        bloglist.add(
            BlogData(R.drawable.sunscreen,"Teens and acne – how to cope","It’s the first day of school, and your teenager has a pimple on their nose. But it’s small – superficial and unassuming. Until they pop it. It’s now red, inflamed and hard to ignore. They want to stay home from school, but you know it’s probably just one pimple.\n\n" +
                    "But what if one pimple turns into full-blown acne?\n\n" +
                    "Many adolescents, teenagers and adults deal with persistent acne, but a one-size-fits-all approach does not exist.It’s never too early to see a dermatologist regarding acne in any form – from blackheads and whiteheads to cystic nodules.\n","Seeking a dermatologist\n\n" +
                    "Patients will come in with whiteheads and blackheads – the least aggressive forms of acne. It’s all about how much a person is bothered by the appearance or feeling of having acne. Small inflammatory papules can still lead to discoloration and acne scarring.\n\n" +
                    "Talking to a teenager about how much their acne distracts them from their daily life is a good place to start. During an appointment, doctors cover various treatment options because the individual’s perception of their acne may change over time.\n\n" +
                    "Oral medication options :\n\n" +
                    "Different medications require more responsibility, especially isotretinoin (conventionally referred to as Accutane), which typically requires 6-7 months of treatment and is the closest thing to a cure for acne.\n\n" +
                    "Dermatologists may prescribe an oral antibiotic as a short-term fix before Accutane. However, antibiotic use longer than three months is not recommended, because the patient runs the risk of developing antibiotic resistance.\n\n" +
                    "Non-medical treatment options :\n\n" +
                    "Using makeup as coverup will likely worsen acne, especially if it is not labelled as non-comedogenic.\n\n")
        )

        bloglist.add(BlogData(R.drawable.melasma,"Melasma: What are the best treatments?","Melasma is a pigmentation disorder of the skin mostly affecting women, especially those with darker skin. It is commonly seen on the face, and appears as dark spots and patches with irregular borders. Melasma is not physically harmful, but studies have shown that it can lead to psychological problems and poorer quality of life due to the changes it causes in a person's appearance.\n\n" +
                "Melasma is a common disorder, with a prevalence of 1% that can increase to 50% in higher-risk groups, including those with darker skin. Melasma is known as the mask of pregnancy since hormonal changes caused by pregnancy, as well as hormonal medications such as birth control pills, are major triggers for excessive skin pigment production in melasma. Sun exposure is another important contributor to melasma.\n",
            "Currently, melasma cannot be fully prevented in people who are likely to develop this condition due to their genetics, skin color type, hormones, or sun exposure level. Avoiding direct sun exposure during peak hours (10 a.m. to 4 p.m.), diligently using high-SPF sunscreens, and avoiding hormonal medications when possible may help protect against melasma flares and reduce their recurrence after treatment. Strict sun protection is the mainstay of any melasma treatment regimen.\n\n" +
                    "The most commonly used treatments for melasma are skin lightening medications that are applied topically. These include medications such as hydroquinone, azelaic acid, kojic acid, niacinamide, cysteamine, rucinol, and tranexamic acid. These medications work by reducing pigment production and inflammation, and by reducing excess blood vessels in the skin that contribute to melasma.\n\n")
        )

        bloglist.add(BlogData(R.drawable.eustudy,"New EU study highlights psychological challenges of living with skin diseases","Published in the Journal of the European Academy of Dermatology and Venereology, the study analysed 19,015 individuals across 27 European countries living with a range of skin diseases, including acne, atopic dermatitis, alopecia, psoriasis.\n" +
                "\n" +
                "The study, The Burden of Skin Disease in Europe, analysed individuals’s journeys from medical consultations to diagnosis, as well as the reasons for not consulting a healthcare professional. The study found that 88% of patients with a skin disease said that their condition was ‘embarrassing’ in their personal lives.\n","Almost half of the adult European population had already declared that they had at least one dermatological disease, according to previous findings from the study." +
                "Additionally, the prevalence of skin diseases is likely to be much higher, as 40% of skin cancers and STD diagnoses remain unrecognised on first consultation." +
                "Skin diseases receive limited policy, research and funding attention, particularly as many individuals avoid medical consultations, which ultimately contributes to an underestimated prevalence.\n" +
                "\n" +
                "This study highlights the alarming psychosocial challenge faced by individuals with skin diseases and underscores the need to provide psychological support to patients and to mitigate the stigmatisation that patients endure in their personal and professional lives. Urgent action must be taken to raise awareness of the impact that skin diseases have on individuals, economies and society and to ensure that patients receive the holistic care they need, including mental health support.\n")
        )

        bloglist.add(BlogData(R.drawable.foodallergy,"Food Allergy Rashes: Causes, Treatments, and Natural Remedies","Food allergy rashes are skin reactions that occur after eating certain foods. The rash may be itchy and red and can occur on any body part. Food allergies are caused by an immune system response to a food protein that the body perceives as harmful.\n\n" +
                "In 2021, it was estimated that 32 million Americans would have food allergy rashes, including 5.6 million children.\n","The best food allergy rashes treatment is to avoid the offending food. This can be difficult, especially if you’re allergic to everyday food items like milk or wheat, which are ubiquitous. If you have a severe allergy, you may need to carry an " +
                "epinephrine auto-injector (such as an EpiPen) with you at all times in case of accidental exposure. For severe allergies, your doctor may prescribe a corticosteroid such as prednisone. Corticosteroids can be taken orally or injected. They are generally safe but can have side effects such as weight gain and mood swings.")
        )

        bloglist.add(
            BlogData(
                R.drawable.covid_hairloss,"COVID-19 continues to affect hair loss","Many patients experienced significant hair loss following COVID-19 infection, according to a case series published in the Journal of Drugs and Dermatology.\n\n" +
                        "The novel coronavirus disease (COVID-19) is caused by severe acute respiratory syndrome coronavirus 2 and primarily affects the epithelium of the airways.\n\n" +
                        "Hair loss has emerged as a frequent noted side effect of infection with COVID-19 and has been observed in many patients who have recovered from a documented COVID-19 illness, the authors continued.\n","A retrospective study was conducted evaluating the prevalence of hair loss in patients who had recovered from COVID-19.\n\n" +
                        "Of 62 patients with hair loss, histological evaluations of hair samples from 48 had telogen effluvium, 12 showed evidence of androgenetic alopecia and two showed alopecia areata.\n\n" +
                        "Telogen effluvium is the most commonly seen cutaneous complication following the recovery from COVID-19. This is perhaps due to the physical and emotional stress that accompanies COVID-19. Furthermore, since fever is a common symptom of COVID-19, a few months after having a high fever or recovering from an illness, many people observe noticeable hair loss.\n\n" +
                        "A strong relationship between hair loss and COVID-19 was found in this study, according to the researchers, raising questions regarding the virus’s effect on autoimmune disorders such as alopecia areata.\n\n" +
                        "Regardless of its nature, hair loss seems to be a common finding following recovery from COVID-19 infection and a larger study may be needed to evaluate what can be done to reduce the number of cases of hair loss.\n\n")
        )

        bloglist.add(
            BlogData(R.drawable.fda,"FDA issues warning about over-the-counter skin lightening products","The FDA has issued warning letters to 12 companies for selling over-the-counter skin lightening products containing hydroquinone, according to a press release.\n\n" +
                    "FDA is alerting consumers there are no FDA-approved or otherwise legally marketed OTC skin lightening products.\n","The FDA has issued warning letters to 12 companies for selling over-the-counter skin lightening products containing hydroquinone.\n\n" +
                    "Serious side effects have been reported with these products including skin rashes, facial swelling and skin discoloration, and the FDA is warning the public not to use any OTC skin lightening products.\n\n" +
                    "Hydroquinone is not approved in any OTC products, as its only indication is for Tri-Luma, a prescription product for the short-term treatment of dark spots associated with melasma.\n\n" +
                    "While some of the companies involved have already removed their products from shelves, the FDA plans to take action against those who continue to sell or market these products.\n\n" +
                    "The organization has asked each company to respond within 15 days detailing how these violations to the CARES act are being addressed.\n\n" +
                    "FDA reminds manufacturers and distributors it is their responsibility to comply with all requirements of federal law and FDA regulations, and to ensure their drugs meet federal standards for safety and effectiveness.\n\n")
        )

        bloglist.add(
            BlogData(R.drawable.sunscreen,"Teens and acne – how to cope","It’s the first day of school, and your teenager has a pimple on their nose. But it’s small – superficial and unassuming. Until they pop it. It’s now red, inflamed and hard to ignore. They want to stay home from school, but you know it’s probably just one pimple.\n\n" +
                    "But what if one pimple turns into full-blown acne?\n\n" +
                    "Many adolescents, teenagers and adults deal with persistent acne, but a one-size-fits-all approach does not exist.It’s never too early to see a dermatologist regarding acne in any form – from blackheads and whiteheads to cystic nodules.\n","Seeking a dermatologist\n\n" +
                    "Patients will come in with whiteheads and blackheads – the least aggressive forms of acne. It’s all about how much a person is bothered by the appearance or feeling of having acne. Small inflammatory papules can still lead to discoloration and acne scarring.\n\n" +
                    "Talking to a teenager about how much their acne distracts them from their daily life is a good place to start. During an appointment, doctors cover various treatment options because the individual’s perception of their acne may change over time.\n\n" +
                    "Oral medication options :\n\n" +
                    "Different medications require more responsibility, especially isotretinoin (conventionally referred to as Accutane), which typically requires 6-7 months of treatment and is the closest thing to a cure for acne.\n\n" +
                    "Dermatologists may prescribe an oral antibiotic as a short-term fix before Accutane. However, antibiotic use longer than three months is not recommended, because the patient runs the risk of developing antibiotic resistance.\n\n" +
                    "Non-medical treatment options :\n\n" +
                    "Using makeup as coverup will likely worsen acne, especially if it is not labelled as non-comedogenic.\n\n")
        )

        bloglist.add(BlogData(R.drawable.melasma,"Melasma: What are the best treatments?","Melasma is a pigmentation disorder of the skin mostly affecting women, especially those with darker skin. It is commonly seen on the face, and appears as dark spots and patches with irregular borders. Melasma is not physically harmful, but studies have shown that it can lead to psychological problems and poorer quality of life due to the changes it causes in a person's appearance.\n\n" +
                "Melasma is a common disorder, with a prevalence of 1% that can increase to 50% in higher-risk groups, including those with darker skin. Melasma is known as the mask of pregnancy since hormonal changes caused by pregnancy, as well as hormonal medications such as birth control pills, are major triggers for excessive skin pigment production in melasma. Sun exposure is another important contributor to melasma.\n",
            "Currently, melasma cannot be fully prevented in people who are likely to develop this condition due to their genetics, skin color type, hormones, or sun exposure level. Avoiding direct sun exposure during peak hours (10 a.m. to 4 p.m.), diligently using high-SPF sunscreens, and avoiding hormonal medications when possible may help protect against melasma flares and reduce their recurrence after treatment. Strict sun protection is the mainstay of any melasma treatment regimen.\n\n" +
                    "The most commonly used treatments for melasma are skin lightening medications that are applied topically. These include medications such as hydroquinone, azelaic acid, kojic acid, niacinamide, cysteamine, rucinol, and tranexamic acid. These medications work by reducing pigment production and inflammation, and by reducing excess blood vessels in the skin that contribute to melasma.\n\n")
        )

        bloglist.add(BlogData(R.drawable.eustudy,"New EU study highlights psychological challenges of living with skin diseases","Published in the Journal of the European Academy of Dermatology and Venereology, the study analysed 19,015 individuals across 27 European countries living with a range of skin diseases, including acne, atopic dermatitis, alopecia, psoriasis.\n" +
                "\n" +
                "The study, The Burden of Skin Disease in Europe, analysed individuals’s journeys from medical consultations to diagnosis, as well as the reasons for not consulting a healthcare professional. The study found that 88% of patients with a skin disease said that their condition was ‘embarrassing’ in their personal lives.\n","Almost half of the adult European population had already declared that they had at least one dermatological disease, according to previous findings from the study." +
                "Additionally, the prevalence of skin diseases is likely to be much higher, as 40% of skin cancers and STD diagnoses remain unrecognised on first consultation." +
                "Skin diseases receive limited policy, research and funding attention, particularly as many individuals avoid medical consultations, which ultimately contributes to an underestimated prevalence.\n" +
                "\n" +
                "This study highlights the alarming psychosocial challenge faced by individuals with skin diseases and underscores the need to provide psychological support to patients and to mitigate the stigmatisation that patients endure in their personal and professional lives. Urgent action must be taken to raise awareness of the impact that skin diseases have on individuals, economies and society and to ensure that patients receive the holistic care they need, including mental health support.\n")
        )

        bloglist.add(BlogData(R.drawable.foodallergy,"Food Allergy Rashes: Causes, Treatments, and Natural Remedies","Food allergy rashes are skin reactions that occur after eating certain foods. The rash may be itchy and red and can occur on any body part. Food allergies are caused by an immune system response to a food protein that the body perceives as harmful.\n\n" +
                "In 2021, it was estimated that 32 million Americans would have food allergy rashes, including 5.6 million children.\n","The best food allergy rashes treatment is to avoid the offending food. This can be difficult, especially if you’re allergic to everyday food items like milk or wheat, which are ubiquitous. If you have a severe allergy, you may need to carry an " +
                "epinephrine auto-injector (such as an EpiPen) with you at all times in case of accidental exposure. For severe allergies, your doctor may prescribe a corticosteroid such as prednisone. Corticosteroids can be taken orally or injected. They are generally safe but can have side effects such as weight gain and mood swings.")
        )

        bloglist.add(
            BlogData(
                R.drawable.covid_hairloss,"COVID-19 continues to affect hair loss","Many patients experienced significant hair loss following COVID-19 infection, according to a case series published in the Journal of Drugs and Dermatology.\n\n" +
                        "The novel coronavirus disease (COVID-19) is caused by severe acute respiratory syndrome coronavirus 2 and primarily affects the epithelium of the airways.\n\n" +
                        "Hair loss has emerged as a frequent noted side effect of infection with COVID-19 and has been observed in many patients who have recovered from a documented COVID-19 illness, the authors continued.\n","A retrospective study was conducted evaluating the prevalence of hair loss in patients who had recovered from COVID-19.\n\n" +
                        "Of 62 patients with hair loss, histological evaluations of hair samples from 48 had telogen effluvium, 12 showed evidence of androgenetic alopecia and two showed alopecia areata.\n\n" +
                        "Telogen effluvium is the most commonly seen cutaneous complication following the recovery from COVID-19. This is perhaps due to the physical and emotional stress that accompanies COVID-19. Furthermore, since fever is a common symptom of COVID-19, a few months after having a high fever or recovering from an illness, many people observe noticeable hair loss.\n\n" +
                        "A strong relationship between hair loss and COVID-19 was found in this study, according to the researchers, raising questions regarding the virus’s effect on autoimmune disorders such as alopecia areata.\n\n" +
                        "Regardless of its nature, hair loss seems to be a common finding following recovery from COVID-19 infection and a larger study may be needed to evaluate what can be done to reduce the number of cases of hair loss.\n\n")
        )

        bloglist.add(
            BlogData(R.drawable.fda,"FDA issues warning about over-the-counter skin lightening products","The FDA has issued warning letters to 12 companies for selling over-the-counter skin lightening products containing hydroquinone, according to a press release.\n\n" +
                    "FDA is alerting consumers there are no FDA-approved or otherwise legally marketed OTC skin lightening products.\n","The FDA has issued warning letters to 12 companies for selling over-the-counter skin lightening products containing hydroquinone.\n\n" +
                    "Serious side effects have been reported with these products including skin rashes, facial swelling and skin discoloration, and the FDA is warning the public not to use any OTC skin lightening products.\n\n" +
                    "Hydroquinone is not approved in any OTC products, as its only indication is for Tri-Luma, a prescription product for the short-term treatment of dark spots associated with melasma.\n\n" +
                    "While some of the companies involved have already removed their products from shelves, the FDA plans to take action against those who continue to sell or market these products.\n\n" +
                    "The organization has asked each company to respond within 15 days detailing how these violations to the CARES act are being addressed.\n\n" +
                    "FDA reminds manufacturers and distributors it is their responsibility to comply with all requirements of federal law and FDA regulations, and to ensure their drugs meet federal standards for safety and effectiveness.\n\n")
        )

        bloglist.add(
            BlogData(R.drawable.sunscreen,"Teens and acne – how to cope","It’s the first day of school, and your teenager has a pimple on their nose. But it’s small – superficial and unassuming. Until they pop it. It’s now red, inflamed and hard to ignore. They want to stay home from school, but you know it’s probably just one pimple.\n\n" +
                    "But what if one pimple turns into full-blown acne?\n\n" +
                    "Many adolescents, teenagers and adults deal with persistent acne, but a one-size-fits-all approach does not exist.It’s never too early to see a dermatologist regarding acne in any form – from blackheads and whiteheads to cystic nodules.\n","Seeking a dermatologist\n\n" +
                    "Patients will come in with whiteheads and blackheads – the least aggressive forms of acne. It’s all about how much a person is bothered by the appearance or feeling of having acne. Small inflammatory papules can still lead to discoloration and acne scarring.\n\n" +
                    "Talking to a teenager about how much their acne distracts them from their daily life is a good place to start. During an appointment, doctors cover various treatment options because the individual’s perception of their acne may change over time.\n\n" +
                    "Oral medication options :\n\n" +
                    "Different medications require more responsibility, especially isotretinoin (conventionally referred to as Accutane), which typically requires 6-7 months of treatment and is the closest thing to a cure for acne.\n\n" +
                    "Dermatologists may prescribe an oral antibiotic as a short-term fix before Accutane. However, antibiotic use longer than three months is not recommended, because the patient runs the risk of developing antibiotic resistance.\n\n" +
                    "Non-medical treatment options :\n\n" +
                    "Using makeup as coverup will likely worsen acne, especially if it is not labelled as non-comedogenic.\n\n")
        )

        bloglist.add(BlogData(R.drawable.melasma,"Melasma: What are the best treatments?","Melasma is a pigmentation disorder of the skin mostly affecting women, especially those with darker skin. It is commonly seen on the face, and appears as dark spots and patches with irregular borders. Melasma is not physically harmful, but studies have shown that it can lead to psychological problems and poorer quality of life due to the changes it causes in a person's appearance.\n\n" +
                "Melasma is a common disorder, with a prevalence of 1% that can increase to 50% in higher-risk groups, including those with darker skin. Melasma is known as the mask of pregnancy since hormonal changes caused by pregnancy, as well as hormonal medications such as birth control pills, are major triggers for excessive skin pigment production in melasma. Sun exposure is another important contributor to melasma.\n",
            "Currently, melasma cannot be fully prevented in people who are likely to develop this condition due to their genetics, skin color type, hormones, or sun exposure level. Avoiding direct sun exposure during peak hours (10 a.m. to 4 p.m.), diligently using high-SPF sunscreens, and avoiding hormonal medications when possible may help protect against melasma flares and reduce their recurrence after treatment. Strict sun protection is the mainstay of any melasma treatment regimen.\n\n" +
                    "The most commonly used treatments for melasma are skin lightening medications that are applied topically. These include medications such as hydroquinone, azelaic acid, kojic acid, niacinamide, cysteamine, rucinol, and tranexamic acid. These medications work by reducing pigment production and inflammation, and by reducing excess blood vessels in the skin that contribute to melasma.\n\n")
        )

        bloglist.add(BlogData(R.drawable.eustudy,"New EU study highlights psychological challenges of living with skin diseases","Published in the Journal of the European Academy of Dermatology and Venereology, the study analysed 19,015 individuals across 27 European countries living with a range of skin diseases, including acne, atopic dermatitis, alopecia, psoriasis.\n" +
                "\n" +
                "The study, The Burden of Skin Disease in Europe, analysed individuals’s journeys from medical consultations to diagnosis, as well as the reasons for not consulting a healthcare professional. The study found that 88% of patients with a skin disease said that their condition was ‘embarrassing’ in their personal lives.\n","Almost half of the adult European population had already declared that they had at least one dermatological disease, according to previous findings from the study." +
                "Additionally, the prevalence of skin diseases is likely to be much higher, as 40% of skin cancers and STD diagnoses remain unrecognised on first consultation." +
                "Skin diseases receive limited policy, research and funding attention, particularly as many individuals avoid medical consultations, which ultimately contributes to an underestimated prevalence.\n" +
                "\n" +
                "This study highlights the alarming psychosocial challenge faced by individuals with skin diseases and underscores the need to provide psychological support to patients and to mitigate the stigmatisation that patients endure in their personal and professional lives. Urgent action must be taken to raise awareness of the impact that skin diseases have on individuals, economies and society and to ensure that patients receive the holistic care they need, including mental health support.\n")
        )

        bloglist.add(BlogData(R.drawable.foodallergy,"Food Allergy Rashes: Causes, Treatments, and Natural Remedies","Food allergy rashes are skin reactions that occur after eating certain foods. The rash may be itchy and red and can occur on any body part. Food allergies are caused by an immune system response to a food protein that the body perceives as harmful.\n\n" +
                "In 2021, it was estimated that 32 million Americans would have food allergy rashes, including 5.6 million children.\n","The best food allergy rashes treatment is to avoid the offending food. This can be difficult, especially if you’re allergic to everyday food items like milk or wheat, which are ubiquitous. If you have a severe allergy, you may need to carry an " +
                "epinephrine auto-injector (such as an EpiPen) with you at all times in case of accidental exposure. For severe allergies, your doctor may prescribe a corticosteroid such as prednisone. Corticosteroids can be taken orally or injected. They are generally safe but can have side effects such as weight gain and mood swings.")
        )

        bloglist.add(
            BlogData(
                R.drawable.covid_hairloss,"COVID-19 continues to affect hair loss","Many patients experienced significant hair loss following COVID-19 infection, according to a case series published in the Journal of Drugs and Dermatology.\n\n" +
                        "The novel coronavirus disease (COVID-19) is caused by severe acute respiratory syndrome coronavirus 2 and primarily affects the epithelium of the airways.\n\n" +
                        "Hair loss has emerged as a frequent noted side effect of infection with COVID-19 and has been observed in many patients who have recovered from a documented COVID-19 illness, the authors continued.\n","A retrospective study was conducted evaluating the prevalence of hair loss in patients who had recovered from COVID-19.\n\n" +
                        "Of 62 patients with hair loss, histological evaluations of hair samples from 48 had telogen effluvium, 12 showed evidence of androgenetic alopecia and two showed alopecia areata.\n\n" +
                        "Telogen effluvium is the most commonly seen cutaneous complication following the recovery from COVID-19. This is perhaps due to the physical and emotional stress that accompanies COVID-19. Furthermore, since fever is a common symptom of COVID-19, a few months after having a high fever or recovering from an illness, many people observe noticeable hair loss.\n\n" +
                        "A strong relationship between hair loss and COVID-19 was found in this study, according to the researchers, raising questions regarding the virus’s effect on autoimmune disorders such as alopecia areata.\n\n" +
                        "Regardless of its nature, hair loss seems to be a common finding following recovery from COVID-19 infection and a larger study may be needed to evaluate what can be done to reduce the number of cases of hair loss.\n\n")
        )

        bloglist.add(
            BlogData(R.drawable.fda,"FDA issues warning about over-the-counter skin lightening products","The FDA has issued warning letters to 12 companies for selling over-the-counter skin lightening products containing hydroquinone, according to a press release.\n\n" +
                    "FDA is alerting consumers there are no FDA-approved or otherwise legally marketed OTC skin lightening products.\n","The FDA has issued warning letters to 12 companies for selling over-the-counter skin lightening products containing hydroquinone.\n\n" +
                    "Serious side effects have been reported with these products including skin rashes, facial swelling and skin discoloration, and the FDA is warning the public not to use any OTC skin lightening products.\n\n" +
                    "Hydroquinone is not approved in any OTC products, as its only indication is for Tri-Luma, a prescription product for the short-term treatment of dark spots associated with melasma.\n\n" +
                    "While some of the companies involved have already removed their products from shelves, the FDA plans to take action against those who continue to sell or market these products.\n\n" +
                    "The organization has asked each company to respond within 15 days detailing how these violations to the CARES act are being addressed.\n\n" +
                    "FDA reminds manufacturers and distributors it is their responsibility to comply with all requirements of federal law and FDA regulations, and to ensure their drugs meet federal standards for safety and effectiveness.\n\n")
        )

        bloglist.add(
            BlogData(R.drawable.sunscreen,"Teens and acne – how to cope","It’s the first day of school, and your teenager has a pimple on their nose. But it’s small – superficial and unassuming. Until they pop it. It’s now red, inflamed and hard to ignore. They want to stay home from school, but you know it’s probably just one pimple.\n\n" +
                    "But what if one pimple turns into full-blown acne?\n\n" +
                    "Many adolescents, teenagers and adults deal with persistent acne, but a one-size-fits-all approach does not exist.It’s never too early to see a dermatologist regarding acne in any form – from blackheads and whiteheads to cystic nodules.\n","Seeking a dermatologist\n\n" +
                    "Patients will come in with whiteheads and blackheads – the least aggressive forms of acne. It’s all about how much a person is bothered by the appearance or feeling of having acne. Small inflammatory papules can still lead to discoloration and acne scarring.\n\n" +
                    "Talking to a teenager about how much their acne distracts them from their daily life is a good place to start. During an appointment, doctors cover various treatment options because the individual’s perception of their acne may change over time.\n\n" +
                    "Oral medication options :\n\n" +
                    "Different medications require more responsibility, especially isotretinoin (conventionally referred to as Accutane), which typically requires 6-7 months of treatment and is the closest thing to a cure for acne.\n\n" +
                    "Dermatologists may prescribe an oral antibiotic as a short-term fix before Accutane. However, antibiotic use longer than three months is not recommended, because the patient runs the risk of developing antibiotic resistance.\n\n" +
                    "Non-medical treatment options :\n\n" +
                    "Using makeup as coverup will likely worsen acne, especially if it is not labelled as non-comedogenic.\n\n")
        )

        bloglist.add(BlogData(R.drawable.melasma,"Melasma: What are the best treatments?","Melasma is a pigmentation disorder of the skin mostly affecting women, especially those with darker skin. It is commonly seen on the face, and appears as dark spots and patches with irregular borders. Melasma is not physically harmful, but studies have shown that it can lead to psychological problems and poorer quality of life due to the changes it causes in a person's appearance.\n\n" +
                "Melasma is a common disorder, with a prevalence of 1% that can increase to 50% in higher-risk groups, including those with darker skin. Melasma is known as the mask of pregnancy since hormonal changes caused by pregnancy, as well as hormonal medications such as birth control pills, are major triggers for excessive skin pigment production in melasma. Sun exposure is another important contributor to melasma.\n",
            "Currently, melasma cannot be fully prevented in people who are likely to develop this condition due to their genetics, skin color type, hormones, or sun exposure level. Avoiding direct sun exposure during peak hours (10 a.m. to 4 p.m.), diligently using high-SPF sunscreens, and avoiding hormonal medications when possible may help protect against melasma flares and reduce their recurrence after treatment. Strict sun protection is the mainstay of any melasma treatment regimen.\n\n" +
                    "The most commonly used treatments for melasma are skin lightening medications that are applied topically. These include medications such as hydroquinone, azelaic acid, kojic acid, niacinamide, cysteamine, rucinol, and tranexamic acid. These medications work by reducing pigment production and inflammation, and by reducing excess blood vessels in the skin that contribute to melasma.\n\n")
        )

        bloglist.add(BlogData(R.drawable.eustudy,"New EU study highlights psychological challenges of living with skin diseases","Published in the Journal of the European Academy of Dermatology and Venereology, the study analysed 19,015 individuals across 27 European countries living with a range of skin diseases, including acne, atopic dermatitis, alopecia, psoriasis.\n" +
                "\n" +
                "The study, The Burden of Skin Disease in Europe, analysed individuals’s journeys from medical consultations to diagnosis, as well as the reasons for not consulting a healthcare professional. The study found that 88% of patients with a skin disease said that their condition was ‘embarrassing’ in their personal lives.\n","Almost half of the adult European population had already declared that they had at least one dermatological disease, according to previous findings from the study." +
                "Additionally, the prevalence of skin diseases is likely to be much higher, as 40% of skin cancers and STD diagnoses remain unrecognised on first consultation." +
                "Skin diseases receive limited policy, research and funding attention, particularly as many individuals avoid medical consultations, which ultimately contributes to an underestimated prevalence.\n" +
                "\n" +
                "This study highlights the alarming psychosocial challenge faced by individuals with skin diseases and underscores the need to provide psychological support to patients and to mitigate the stigmatisation that patients endure in their personal and professional lives. Urgent action must be taken to raise awareness of the impact that skin diseases have on individuals, economies and society and to ensure that patients receive the holistic care they need, including mental health support.\n")
        )

        bloglist.add(BlogData(R.drawable.foodallergy,"Food Allergy Rashes: Causes, Treatments, and Natural Remedies","Food allergy rashes are skin reactions that occur after eating certain foods. The rash may be itchy and red and can occur on any body part. Food allergies are caused by an immune system response to a food protein that the body perceives as harmful.\n\n" +
                "In 2021, it was estimated that 32 million Americans would have food allergy rashes, including 5.6 million children.\n","The best food allergy rashes treatment is to avoid the offending food. This can be difficult, especially if you’re allergic to everyday food items like milk or wheat, which are ubiquitous. If you have a severe allergy, you may need to carry an " +
                "epinephrine auto-injector (such as an EpiPen) with you at all times in case of accidental exposure. For severe allergies, your doctor may prescribe a corticosteroid such as prednisone. Corticosteroids can be taken orally or injected. They are generally safe but can have side effects such as weight gain and mood swings.")
        )

        bloglist.add(
            BlogData(
                R.drawable.covid_hairloss,"COVID-19 continues to affect hair loss","Many patients experienced significant hair loss following COVID-19 infection, according to a case series published in the Journal of Drugs and Dermatology.\n\n" +
                        "The novel coronavirus disease (COVID-19) is caused by severe acute respiratory syndrome coronavirus 2 and primarily affects the epithelium of the airways.\n\n" +
                        "Hair loss has emerged as a frequent noted side effect of infection with COVID-19 and has been observed in many patients who have recovered from a documented COVID-19 illness, the authors continued.\n","A retrospective study was conducted evaluating the prevalence of hair loss in patients who had recovered from COVID-19.\n\n" +
                        "Of 62 patients with hair loss, histological evaluations of hair samples from 48 had telogen effluvium, 12 showed evidence of androgenetic alopecia and two showed alopecia areata.\n\n" +
                        "Telogen effluvium is the most commonly seen cutaneous complication following the recovery from COVID-19. This is perhaps due to the physical and emotional stress that accompanies COVID-19. Furthermore, since fever is a common symptom of COVID-19, a few months after having a high fever or recovering from an illness, many people observe noticeable hair loss.\n\n" +
                        "A strong relationship between hair loss and COVID-19 was found in this study, according to the researchers, raising questions regarding the virus’s effect on autoimmune disorders such as alopecia areata.\n\n" +
                        "Regardless of its nature, hair loss seems to be a common finding following recovery from COVID-19 infection and a larger study may be needed to evaluate what can be done to reduce the number of cases of hair loss.\n\n")
        )

        bloglist.add(
            BlogData(R.drawable.fda,"FDA issues warning about over-the-counter skin lightening products","The FDA has issued warning letters to 12 companies for selling over-the-counter skin lightening products containing hydroquinone, according to a press release.\n\n" +
                    "FDA is alerting consumers there are no FDA-approved or otherwise legally marketed OTC skin lightening products.\n","The FDA has issued warning letters to 12 companies for selling over-the-counter skin lightening products containing hydroquinone.\n\n" +
                    "Serious side effects have been reported with these products including skin rashes, facial swelling and skin discoloration, and the FDA is warning the public not to use any OTC skin lightening products.\n\n" +
                    "Hydroquinone is not approved in any OTC products, as its only indication is for Tri-Luma, a prescription product for the short-term treatment of dark spots associated with melasma.\n\n" +
                    "While some of the companies involved have already removed their products from shelves, the FDA plans to take action against those who continue to sell or market these products.\n\n" +
                    "The organization has asked each company to respond within 15 days detailing how these violations to the CARES act are being addressed.\n\n" +
                    "FDA reminds manufacturers and distributors it is their responsibility to comply with all requirements of federal law and FDA regulations, and to ensure their drugs meet federal standards for safety and effectiveness.\n\n")
        )

        bloglist.add(
            BlogData(R.drawable.sunscreen,"Teens and acne – how to cope","It’s the first day of school, and your teenager has a pimple on their nose. But it’s small – superficial and unassuming. Until they pop it. It’s now red, inflamed and hard to ignore. They want to stay home from school, but you know it’s probably just one pimple.\n\n" +
                    "But what if one pimple turns into full-blown acne?\n\n" +
                    "Many adolescents, teenagers and adults deal with persistent acne, but a one-size-fits-all approach does not exist.It’s never too early to see a dermatologist regarding acne in any form – from blackheads and whiteheads to cystic nodules.\n","Seeking a dermatologist\n\n" +
                    "Patients will come in with whiteheads and blackheads – the least aggressive forms of acne. It’s all about how much a person is bothered by the appearance or feeling of having acne. Small inflammatory papules can still lead to discoloration and acne scarring.\n\n" +
                    "Talking to a teenager about how much their acne distracts them from their daily life is a good place to start. During an appointment, doctors cover various treatment options because the individual’s perception of their acne may change over time.\n\n" +
                    "Oral medication options :\n\n" +
                    "Different medications require more responsibility, especially isotretinoin (conventionally referred to as Accutane), which typically requires 6-7 months of treatment and is the closest thing to a cure for acne.\n\n" +
                    "Dermatologists may prescribe an oral antibiotic as a short-term fix before Accutane. However, antibiotic use longer than three months is not recommended, because the patient runs the risk of developing antibiotic resistance.\n\n" +
                    "Non-medical treatment options :\n\n" +
                    "Using makeup as coverup will likely worsen acne, especially if it is not labelled as non-comedogenic.\n\n")
        )

        bloglist.add(BlogData(R.drawable.melasma,"Melasma: What are the best treatments?","Melasma is a pigmentation disorder of the skin mostly affecting women, especially those with darker skin. It is commonly seen on the face, and appears as dark spots and patches with irregular borders. Melasma is not physically harmful, but studies have shown that it can lead to psychological problems and poorer quality of life due to the changes it causes in a person's appearance.\n\n" +
                "Melasma is a common disorder, with a prevalence of 1% that can increase to 50% in higher-risk groups, including those with darker skin. Melasma is known as the mask of pregnancy since hormonal changes caused by pregnancy, as well as hormonal medications such as birth control pills, are major triggers for excessive skin pigment production in melasma. Sun exposure is another important contributor to melasma.\n",
            "Currently, melasma cannot be fully prevented in people who are likely to develop this condition due to their genetics, skin color type, hormones, or sun exposure level. Avoiding direct sun exposure during peak hours (10 a.m. to 4 p.m.), diligently using high-SPF sunscreens, and avoiding hormonal medications when possible may help protect against melasma flares and reduce their recurrence after treatment. Strict sun protection is the mainstay of any melasma treatment regimen.\n\n" +
                    "The most commonly used treatments for melasma are skin lightening medications that are applied topically. These include medications such as hydroquinone, azelaic acid, kojic acid, niacinamide, cysteamine, rucinol, and tranexamic acid. These medications work by reducing pigment production and inflammation, and by reducing excess blood vessels in the skin that contribute to melasma.\n\n")
        )

        bloglist.add(BlogData(R.drawable.eustudy,"New EU study highlights psychological challenges of living with skin diseases","Published in the Journal of the European Academy of Dermatology and Venereology, the study analysed 19,015 individuals across 27 European countries living with a range of skin diseases, including acne, atopic dermatitis, alopecia, psoriasis.\n" +
                "\n" +
                "The study, The Burden of Skin Disease in Europe, analysed individuals’s journeys from medical consultations to diagnosis, as well as the reasons for not consulting a healthcare professional. The study found that 88% of patients with a skin disease said that their condition was ‘embarrassing’ in their personal lives.\n","Almost half of the adult European population had already declared that they had at least one dermatological disease, according to previous findings from the study." +
                "Additionally, the prevalence of skin diseases is likely to be much higher, as 40% of skin cancers and STD diagnoses remain unrecognised on first consultation." +
                "Skin diseases receive limited policy, research and funding attention, particularly as many individuals avoid medical consultations, which ultimately contributes to an underestimated prevalence.\n" +
                "\n" +
                "This study highlights the alarming psychosocial challenge faced by individuals with skin diseases and underscores the need to provide psychological support to patients and to mitigate the stigmatisation that patients endure in their personal and professional lives. Urgent action must be taken to raise awareness of the impact that skin diseases have on individuals, economies and society and to ensure that patients receive the holistic care they need, including mental health support.\n")
        )

        bloglist.add(BlogData(R.drawable.foodallergy,"Food Allergy Rashes: Causes, Treatments, and Natural Remedies","Food allergy rashes are skin reactions that occur after eating certain foods. The rash may be itchy and red and can occur on any body part. Food allergies are caused by an immune system response to a food protein that the body perceives as harmful.\n\n" +
                "In 2021, it was estimated that 32 million Americans would have food allergy rashes, including 5.6 million children.\n","The best food allergy rashes treatment is to avoid the offending food. This can be difficult, especially if you’re allergic to everyday food items like milk or wheat, which are ubiquitous. If you have a severe allergy, you may need to carry an " +
                "epinephrine auto-injector (such as an EpiPen) with you at all times in case of accidental exposure. For severe allergies, your doctor may prescribe a corticosteroid such as prednisone. Corticosteroids can be taken orally or injected. They are generally safe but can have side effects such as weight gain and mood swings.")
        )

        bloglist.add(
            BlogData(
                R.drawable.covid_hairloss,"COVID-19 continues to affect hair loss","Many patients experienced significant hair loss following COVID-19 infection, according to a case series published in the Journal of Drugs and Dermatology.\n\n" +
                        "The novel coronavirus disease (COVID-19) is caused by severe acute respiratory syndrome coronavirus 2 and primarily affects the epithelium of the airways.\n\n" +
                        "Hair loss has emerged as a frequent noted side effect of infection with COVID-19 and has been observed in many patients who have recovered from a documented COVID-19 illness, the authors continued.\n","A retrospective study was conducted evaluating the prevalence of hair loss in patients who had recovered from COVID-19.\n\n" +
                        "Of 62 patients with hair loss, histological evaluations of hair samples from 48 had telogen effluvium, 12 showed evidence of androgenetic alopecia and two showed alopecia areata.\n\n" +
                        "Telogen effluvium is the most commonly seen cutaneous complication following the recovery from COVID-19. This is perhaps due to the physical and emotional stress that accompanies COVID-19. Furthermore, since fever is a common symptom of COVID-19, a few months after having a high fever or recovering from an illness, many people observe noticeable hair loss.\n\n" +
                        "A strong relationship between hair loss and COVID-19 was found in this study, according to the researchers, raising questions regarding the virus’s effect on autoimmune disorders such as alopecia areata.\n\n" +
                        "Regardless of its nature, hair loss seems to be a common finding following recovery from COVID-19 infection and a larger study may be needed to evaluate what can be done to reduce the number of cases of hair loss.\n\n")
        )

        bloglist.add(
            BlogData(R.drawable.fda,"FDA issues warning about over-the-counter skin lightening products","The FDA has issued warning letters to 12 companies for selling over-the-counter skin lightening products containing hydroquinone, according to a press release.\n\n" +
                    "FDA is alerting consumers there are no FDA-approved or otherwise legally marketed OTC skin lightening products.\n","The FDA has issued warning letters to 12 companies for selling over-the-counter skin lightening products containing hydroquinone.\n\n" +
                    "Serious side effects have been reported with these products including skin rashes, facial swelling and skin discoloration, and the FDA is warning the public not to use any OTC skin lightening products.\n\n" +
                    "Hydroquinone is not approved in any OTC products, as its only indication is for Tri-Luma, a prescription product for the short-term treatment of dark spots associated with melasma.\n\n" +
                    "While some of the companies involved have already removed their products from shelves, the FDA plans to take action against those who continue to sell or market these products.\n\n" +
                    "The organization has asked each company to respond within 15 days detailing how these violations to the CARES act are being addressed.\n\n" +
                    "FDA reminds manufacturers and distributors it is their responsibility to comply with all requirements of federal law and FDA regulations, and to ensure their drugs meet federal standards for safety and effectiveness.\n\n")
        )

        bloglist.add(
            BlogData(R.drawable.sunscreen,"Teens and acne – how to cope","It’s the first day of school, and your teenager has a pimple on their nose. But it’s small – superficial and unassuming. Until they pop it. It’s now red, inflamed and hard to ignore. They want to stay home from school, but you know it’s probably just one pimple.\n\n" +
                    "But what if one pimple turns into full-blown acne?\n\n" +
                    "Many adolescents, teenagers and adults deal with persistent acne, but a one-size-fits-all approach does not exist.It’s never too early to see a dermatologist regarding acne in any form – from blackheads and whiteheads to cystic nodules.\n","Seeking a dermatologist\n\n" +
                    "Patients will come in with whiteheads and blackheads – the least aggressive forms of acne. It’s all about how much a person is bothered by the appearance or feeling of having acne. Small inflammatory papules can still lead to discoloration and acne scarring.\n\n" +
                    "Talking to a teenager about how much their acne distracts them from their daily life is a good place to start. During an appointment, doctors cover various treatment options because the individual’s perception of their acne may change over time.\n\n" +
                    "Oral medication options :\n\n" +
                    "Different medications require more responsibility, especially isotretinoin (conventionally referred to as Accutane), which typically requires 6-7 months of treatment and is the closest thing to a cure for acne.\n\n" +
                    "Dermatologists may prescribe an oral antibiotic as a short-term fix before Accutane. However, antibiotic use longer than three months is not recommended, because the patient runs the risk of developing antibiotic resistance.\n\n" +
                    "Non-medical treatment options :\n\n" +
                    "Using makeup as coverup will likely worsen acne, especially if it is not labelled as non-comedogenic.\n\n")
        )

        bloglist.add(BlogData(R.drawable.melasma,"Melasma: What are the best treatments?","Melasma is a pigmentation disorder of the skin mostly affecting women, especially those with darker skin. It is commonly seen on the face, and appears as dark spots and patches with irregular borders. Melasma is not physically harmful, but studies have shown that it can lead to psychological problems and poorer quality of life due to the changes it causes in a person's appearance.\n\n" +
                "Melasma is a common disorder, with a prevalence of 1% that can increase to 50% in higher-risk groups, including those with darker skin. Melasma is known as the mask of pregnancy since hormonal changes caused by pregnancy, as well as hormonal medications such as birth control pills, are major triggers for excessive skin pigment production in melasma. Sun exposure is another important contributor to melasma.\n",
            "Currently, melasma cannot be fully prevented in people who are likely to develop this condition due to their genetics, skin color type, hormones, or sun exposure level. Avoiding direct sun exposure during peak hours (10 a.m. to 4 p.m.), diligently using high-SPF sunscreens, and avoiding hormonal medications when possible may help protect against melasma flares and reduce their recurrence after treatment. Strict sun protection is the mainstay of any melasma treatment regimen.\n\n" +
                    "The most commonly used treatments for melasma are skin lightening medications that are applied topically. These include medications such as hydroquinone, azelaic acid, kojic acid, niacinamide, cysteamine, rucinol, and tranexamic acid. These medications work by reducing pigment production and inflammation, and by reducing excess blood vessels in the skin that contribute to melasma.\n\n")
        )

        bloglist.add(BlogData(R.drawable.eustudy,"New EU study highlights psychological challenges of living with skin diseases","Published in the Journal of the European Academy of Dermatology and Venereology, the study analysed 19,015 individuals across 27 European countries living with a range of skin diseases, including acne, atopic dermatitis, alopecia, psoriasis.\n" +
                "\n" +
                "The study, The Burden of Skin Disease in Europe, analysed individuals’s journeys from medical consultations to diagnosis, as well as the reasons for not consulting a healthcare professional. The study found that 88% of patients with a skin disease said that their condition was ‘embarrassing’ in their personal lives.\n","Almost half of the adult European population had already declared that they had at least one dermatological disease, according to previous findings from the study." +
                "Additionally, the prevalence of skin diseases is likely to be much higher, as 40% of skin cancers and STD diagnoses remain unrecognised on first consultation." +
                "Skin diseases receive limited policy, research and funding attention, particularly as many individuals avoid medical consultations, which ultimately contributes to an underestimated prevalence.\n" +
                "\n" +
                "This study highlights the alarming psychosocial challenge faced by individuals with skin diseases and underscores the need to provide psychological support to patients and to mitigate the stigmatisation that patients endure in their personal and professional lives. Urgent action must be taken to raise awareness of the impact that skin diseases have on individuals, economies and society and to ensure that patients receive the holistic care they need, including mental health support.\n")
        )

        bloglist.add(BlogData(R.drawable.foodallergy,"Food Allergy Rashes: Causes, Treatments, and Natural Remedies","Food allergy rashes are skin reactions that occur after eating certain foods. The rash may be itchy and red and can occur on any body part. Food allergies are caused by an immune system response to a food protein that the body perceives as harmful.\n\n" +
                "In 2021, it was estimated that 32 million Americans would have food allergy rashes, including 5.6 million children.\n","The best food allergy rashes treatment is to avoid the offending food. This can be difficult, especially if you’re allergic to everyday food items like milk or wheat, which are ubiquitous. If you have a severe allergy, you may need to carry an " +
                "epinephrine auto-injector (such as an EpiPen) with you at all times in case of accidental exposure. For severe allergies, your doctor may prescribe a corticosteroid such as prednisone. Corticosteroids can be taken orally or injected. They are generally safe but can have side effects such as weight gain and mood swings.")
        )

        binding.blogRV.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        binding.blogRV.setHasFixedSize(true)
        binding.blogRV.adapter = BlogAdapter(bloglist, requireContext())

    }

}