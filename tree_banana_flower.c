#include <stdio.h>
#include <stdlib.h>

//Structs
struct Person{
    char name[50];
    int age;
    double bodyMassIndex;
    int lifestyleIndex;
};

//Prototypes
int createPerson();
double calculateBMIScore();
int calculateLifestyleIndex();
int giveRecommendation(struct Person person);

//Main Function
int main() {
    struct Person person;
    createPerson(&person);
    person.bodyMassIndex = calculateBMIScore(person);
    person.lifestyleIndex = calculateLifestyleIndex(person);
    giveRecommendation(&person);

    return 0;
}

//Function Definitions
int createPerson(struct Person *person)
{
    printf("What is your name?\n");
    scanf("%s", person->name);
    printf("What is your age?\n");
    scanf("%d", &person->age);
    return 0;
}

double calculateBMIScore(struct Person person)
{
    double bodyWeight, height;
    printf("Please enter your body weight (kg):\n");
    scanf("%lf", &bodyWeight);
    printf("Please enter your height (m):\n");
    scanf("%lf", &height);
    double bmi = bodyWeight / (height * height);
    return bmi;
}

int calculateLifestyleIndex(struct Person person)
{
    int lifestyleIndex;
    int sleep, exercise, diet;
    printf("How much sleep do you get each night (in hours)?\n");
    scanf("%d", &sleep);
    printf("How often do you exercise (in days per week)?\n");
    scanf("%d", &exercise);
    printf("How would you rate your diet (1-5)?\n");
    scanf("%d", &diet);
    lifestyleIndex = sleep + (exercise * 2) + (diet * 5);
    return lifestyleIndex;
}

int giveRecommendation(struct Person person)
{
    if(person.bodyMassIndex < 18.5){
        printf("Your BMI score is low. I recommend adding some more healthy calories to your diet.\n");
    }
    else if(person.bodyMassIndex >= 18.5 && person.bodyMassIndex <= 24.9){
        printf("Your BMI is within an acceptable range. Try to maintain your current diet and lifestyle.\n");
    }
    else{
        printf("Your BMI is high. I recommend reducing your calorie intake and incorporating more exercise into your week.\n");
    }
    if(person.lifestyleIndex <= 16){
        printf("Your lifestyle index is low. I recommend increasing the amount of sleep and exercise you get each week.\n");
    }
    else if(person.lifestyleIndex >= 17 && person.lifestyleIndex <= 33){
        printf("Your lifestyle index is within an acceptable range. Continue with your current lifestyle and diet.\n");
    }
    else{
        printf("Your lifestyle index is high. I suggest reducing the amount of time you spend sedentary and balancing your sleep, exercise, and diet.\n");
    }
    return 0;
}