# Generated by Django 3.1.7 on 2021-04-05 17:11

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('accounts', '0008_auto_20210405_1440'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='students',
            name='password1',
        ),
        migrations.RemoveField(
            model_name='students',
            name='password2',
        ),
        migrations.AlterField(
            model_name='students',
            name='email',
            field=models.CharField(max_length=200, unique=True),
        ),
    ]
