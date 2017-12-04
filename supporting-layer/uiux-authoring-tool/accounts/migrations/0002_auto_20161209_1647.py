# -*- coding: utf-8 -*-
# Generated by Django 1.10.3 on 2016-12-09 07:47
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('accounts', '0001_initial'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='myuser',
            name='zipcode',
        ),
        migrations.AddField(
            model_name='myuser',
            name='date_of_birth',
            field=models.DateField(blank=True, null=True),
        ),
        migrations.AddField(
            model_name='myuser',
            name='gender',
            field=models.CharField(max_length=50, null=True),
        ),
        migrations.AddField(
            model_name='myuser',
            name='height',
            field=models.IntegerField(blank=True, null=True),
        ),
        migrations.AddField(
            model_name='myuser',
            name='user_hearing',
            field=models.CharField(max_length=50, null=True),
        ),
        migrations.AddField(
            model_name='myuser',
            name='user_sight',
            field=models.CharField(max_length=50, null=True),
        ),
        migrations.AddField(
            model_name='myuser',
            name='user_touch',
            field=models.CharField(max_length=50, null=True),
        ),
        migrations.AddField(
            model_name='myuser',
            name='weight',
            field=models.IntegerField(blank=True, null=True),
        ),
    ]
