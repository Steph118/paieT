if (window.PrimeFaces) {
  /** Turkish */
  PrimeFaces.locales["tr"] = {
    accept: "Tamam",
    addRule: "Kural Ekle",
    am: "ÖÖ",
    apply: "Uygula",
    cancel: "Vazgeç",
    choose: "Seç",
    chooseDate: "Tarih Seçiniz",
    chooseMonth: "Ay Seçiniz",
    chooseYear: "Yıl Seçiniz",
    clear: "Temiz",
    completed: "Tamamlandı",
    contains: "Barındırır",
    custom: "Özel",
    dateAfter: "Tarihten sonra",
    dateBefore: "Tarihten önce",
    dateFormat: "dd.mm.yy",
    dateIs: "Tarih",
    dateIsNot: "Tarih değildir",
    dayNames: ["Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"],
    dayNamesMin: ["Pz", "Pt", "Sa", "Ça", "Pe", "Cu", "Ct"],
    dayNamesShort: ["Paz", "Pzt", "Sal", "Çar", "Per", "Cum", "Cmt"],
    emptyFilterMessage: "Kullanılabilir seçenek yok",
    emptyMessage: "Sonuç bulunamadı",
    emptySearchMessage: "Sonuç bulunmadı",
    emptySelectionMessage: "Öge seçilmedi",
    endsWith: "Bitiş",
    equals: "Eşittir",
    fileSizeTypes: ["B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"],
    filter: "Filtre",
    firstDayOfWeek: 1,
    gt: "Daha Fazla",
    gte: "Daha fazla veya Eşit",
    lt: "Daha az",
    lte: "Daha az veya Eşit",
    matchAll: "Tümüyle eşleşir",
    matchAny: "Herhangi birine eşleşir",
    medium: "Orta",
    monthNames: ["Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"],
    monthNamesShort: ["Oca", "Şub", "Mar", "Nis", "May", "Haz", "Tem", "Ağu", "Eyl", "Eki", "Kas", "Ara"],
    nextDecade: "Gelecek On Yıl",
    nextHour: "Gelecek Saat",
    nextMinute: "Gelecek Dakika",
    nextMonth: "Gelecek Ay",
    nextSecond: "Gelecek Saniye",
    nextYear: "Gelecek Yıl",
    noFilter: "Filtresiz",
    notContains: "İçinde Barındırmaz",
    notEquals: "Eşit Değildir",
    now: "Şimdi",
    passwordPrompt: "Parola Giriniz",
    pending: "Askıda",
    pm: "ÖS",
    prevDecade: "Önceki On Yıl",
    prevHour: "Geçen Saat",
    prevMinute: "Geçen Dakika",
    prevMonth: "Geçen Ay",
    prevSecond: "Geçen Saniye",
    prevYear: "Geçen Yıl",
    reject: "İptal",
    removeRule: "Kuralı Sil",
    searchMessage: "{0} sonuç bulundu",
    selectionMessage: "{0} öge seçildi",
    showMonthAfterYear: false,
    startsWith: "Başlangıç",
    strong: "Güçlü",
    today: "Bugün",
    upload: "Yükle",
    weak: "Zayıf",
    weekHeader: "Hf",
    aria: {
      cancelEdit: "Düzenlemeyi İptal Et",
      close: "Kapat",
      collapseLabel: "Yıkılmak",
      collapseRow: "Satır Daraltıldı",
      editRow: "Satırı Düzenle",
      expandLabel: "Genişletmek",
      expandRow: "Satır Genişletildi",
      falseLabel: "Yanlış",
      filterConstraint: "Filter Constraint",
      filterOperator: "Filtre Araçları",
      firstPageLabel: "İlk Sayfa",
      gridView: "Izgara Görünümü",
      hideFilterMenu: "Filtre Menüsünü Gizle",
      jumpToPageDropdownLabel: "Açılan Sayfaya Git",
      jumpToPageInputLabel: "Giriş Yapılan Sayfaya git",
      lastPageLabel: "Son Sayfa",
      listView: "Liste Görünümü",
      moveAllToSource: "Tümünü kaynağa taşı",
      moveAllToTarget: "Tümünü hedefe taşı",
      moveBottom: "En aşağıya taşı",
      moveDown: "Aşağıya taşı",
      moveTop: "En üste taşı",
      moveToSource: "Kaynağa taşı",
      moveToTarget: "Hedefe taşı",
      moveUp: "Üste taşı",
      navigation: "Navigasyon",
      next: "Sonraki",
      nextPageLabel: "Sonraki Sayfa",
      nullLabel: "Seçilmedi",
      otpLabel: "Lütfen tek kullanımlık şifre karakteri {0} girin",
      pageLabel: "Sayfa {page}",
      passwordHide: "Şifreyi gizle",
      passwordShow: "Şifreyi göster",
      previous: "Önceki",
      previousPageLabel: "Önceki Sayfa",
      rotateLeft: "Sola Döndür",
      rotateRight: "Sağa Döndür",
      rowsPerPageLabel: "Sayfa başına satır",
      saveEdit: "Düzenlemeyi Kaydet",
      scrollTop: "Yukarı çık",
      selectAll: "Tüm ögeler seçildi",
      selectLabel: "Seçme",
      selectRow: "Satır Seçildi",
      showFilterMenu: "Filtre Menüsünü Göster",
      slide: "Slayt",
      slideNumber: "{slideNumber}",
      star: "1 yıldız",
      stars: "{star} yıldız",
      trueLabel: "Doğru",
      unselectAll: "Tüm ögelerden seçim kaldırıldı",
      unselectLabel: "Seçimi kaldır",
      unselectRow: "Satır Seçilmedi",
      zoomImage: "Görüntüyü Yakınlaştır",
      zoomIn: "Yakınlaştır",
      zoomOut: "Uzaklaştır",
    },
  };

  // custom PF labels
  PrimeFaces.locales["tr"] = $.extend(true, {}, PrimeFaces.locales["tr"], {
    weekNumberTitle: "Hf",
    isRTL: false,
    yearSuffix: "",
    timeOnlyTitle: "Zaman Seçiniz",
    timeText: "Zaman",
    hourText: "Saat",
    minuteText: "Dakika",
    secondText: "Saniye",
    millisecondText: "Milisaniye",
    year: "Yıl",
    month: "Ay",
    week: "Hafta",
    day: "Gün",
    list: "Agenda",
    allDayText: "Tüm Gün",
    moreLinkText: "Daha Fazla...",
    noEventsText: "Etkinlik Yok",
    aria: {
      "datatable.sort.ASC": "Sütunu artan sıralamak için etkinleştir",
      "datatable.sort.DESC": "Sütunu azalan sıralamak için etkinleştir",
      "colorpicker.OPEN": "Renk seçiciyi aç",
      "colorpicker.CLOSE": "Renk seçiciyi kapat",
      "colorpicker.CLEAR": "Seçili rengi temizle",
      "colorpicker.MARKER": "Doygunluk: {s}. Parlaklık: {v}.",
      "colorpicker.HUESLIDER": "Ton kaydırıcı",
      "colorpicker.ALPHASLIDER": "Opaklık kaydırıcısı",
      "colorpicker.INPUT": "Renk değeri alanı",
      "colorpicker.FORMAT": "Renk formatı",
      "colorpicker.SWATCH": "Renk örneği",
      "colorpicker.INSTRUCTION": "Doygunluk ve parlaklık seçici. Seçmek için yukarı, aşağı, sol ve sağ ok tuşlarını kullanın.",
      "spinner.INCREASE": "Değer artışı",
      "spinner.DECREASE": "Değer düşüşü",
      "switch.ON": "Açık",
      "switch.OFF": "Kapalı",
      "messages.ERROR": "Hata",
      "messages.FATAL": "Kritik Hata",
      "messages.INFO": "Bilgi",
      "messages.WARN": "Uyarı",
    },
    messages: {
      //optional for Client Side Validation
      "javax.faces.component.UIInput.REQUIRED": "{0}: Doğrulama Hatası: Değer gerekli.",
      "javax.faces.converter.IntegerConverter.INTEGER": "{2}: '{0}' sayısı bir veya daha fazla rakamdan oluşmalıdır.",
      "javax.faces.converter.IntegerConverter.INTEGER_detail": "{2}: '{0}' sayısı -2147483648 ve 2147483647 arasında olmalıdır. Örnek: {1}.",
      "javax.faces.converter.DoubleConverter.DOUBLE": "{2}: '{0}' sayısı bir veya daha fazla rakamdan oluşmalıdır.",
      "javax.faces.converter.DoubleConverter.DOUBLE_detail": "{2}: '{0}' sayısı 4.9E-324 ve 1.7976931348623157E308 arasında olmalıdır. Örnek: {1}.",
      "javax.faces.converter.BigDecimalConverter.DECIMAL": "{2}: '{0}' işaretli bir ondalık sayı olmalıdır.",
      "javax.faces.converter.BigDecimalConverter.DECIMAL_detail": "{2}: '{0}' sıfır veya daha fazla basamaktan oluşan işaretli bir ondalık sayı olmalıdır, ardından bir ondalık virgül veya kesir gelebilir. Örnek: {1}.",
      "javax.faces.converter.BigIntegerConverter.BIGINTEGER": "{2}: '{0}' sayısı bir veya daha fazla rakamdan oluşmalıdır.",
      "javax.faces.converter.BigIntegerConverter.BIGINTEGER_detail": "{2}: '{0}' sayısı bir veya daha fazla rakamdan oluşmalıdır. Örnek: {1}.",
      "javax.faces.converter.ByteConverter.BYTE": "{2}: '{0}' sayısı 0 ve 255 arasında olmalıdır.",
      "javax.faces.converter.ByteConverter.BYTE_detail": "{2}: '{0}' sayısı 0 ve 255 arasında olmalıdır. Örnek: {1}.",
      "javax.faces.converter.CharacterConverter.CHARACTER": "{1}: '{0}' değeri geçerli bir karakter olmalı.",
      "javax.faces.converter.CharacterConverter.CHARACTER_detail": "{1}: '{0}' değeri geçerli bir ASCII karakteri olmalı.",
      "javax.faces.converter.ShortConverter.SHORT": "{2}: '{0}' sayısı bir veya daha fazla rakamdan oluşmalıdır.",
      "javax.faces.converter.ShortConverter.SHORT_detail": "{2}: '{0}' sayısı -32768 ve 32767 arasında olmalıdır. Örnek: {1}.",
      "javax.faces.converter.BooleanConverter.BOOLEAN": "{1}: '{0}' değeri 'true' (doğru) yada 'false' (yanlış) olmalıdır.",
      "javax.faces.converter.BooleanConverter.BOOLEAN_detail": "{1}: '{0}' değeri 'true' (doğru) yada 'false' (yanlış) olmalıdır. 'true' dışındaki değerler 'false' olarak değerlendirilir.",
      "javax.faces.validator.LongRangeValidator.MAXIMUM": "{1}: Doğrulama Hatası: Değer izin verilen maksimum değerden daha büyük: '{0}'.",
      "javax.faces.validator.LongRangeValidator.MINIMUM": "{1}: Doğrulama Hatası: Değer izin verilen minimum değerden daha düşük: '{0}'.",
      "javax.faces.validator.LongRangeValidator.NOT_IN_RANGE": "{2}: Doğrulama Hatası: Belirtilen öznitelik {0} ve {1} değerleri arasında değil.",
      "javax.faces.validator.LongRangeValidator.TYPE": "{0}: Doğrulama Hatası: Değer doğru türde değil.",
      "javax.faces.validator.DoubleRangeValidator.MAXIMUM": "{1}: Doğrulama Hatası: Değer izin verilen maksimum değerden daha büyük: '{0}'.",
      "javax.faces.validator.DoubleRangeValidator.MINIMUM": "{1}: Doğrulama Hatası: Değer izin verilen minimum değerden daha düşük: '{0}'.",
      "javax.faces.validator.DoubleRangeValidator.NOT_IN_RANGE": "{2}: Doğrulama Hatası: Belirtilen öznitelik {0} ve {1} değerleri arasında değil.",
      "javax.faces.validator.DoubleRangeValidator.TYPE": "{0}: Doğrulama Hatası: Değer doğru türde değil.",
      "javax.faces.converter.FloatConverter.FLOAT": "{2}: '{0}' sayısı bir veya daha fazla rakamdan oluşmalıdır.",
      "javax.faces.converter.FloatConverter.FLOAT_detail": "{2}: '{0}' sayısı 1.4E-45 ve 3.4028235E38 arasında olmalıdır. Örnek: {1}.",
      "javax.faces.converter.DateTimeConverter.DATE": "{2}: '{0}' değeri tarih olarak anlaşılamadı.",
      "javax.faces.converter.DateTimeConverter.DATE_detail": "{2}: '{0}' değeri  tarih olarak anlaşılamadı. Örnek: {1}.",
      "javax.faces.converter.DateTimeConverter.TIME": "{2}: '{0}' değeri  saat olarak anlaşılamadı.",
      "javax.faces.converter.DateTimeConverter.TIME_detail": "{2}: '{0}' değeri  saat olarak anlaşılamadı. Örnek: {1}.",
      "javax.faces.converter.DateTimeConverter.DATETIME": "{2}: '{0}' değeri tarih ve saat olarak anlaşılamadı.",
      "javax.faces.converter.DateTimeConverter.DATETIME_detail": "{2}: '{0}' değeri tarih ve saat olarak anlaşılamadı. Örnek: {1}.",
      "javax.faces.converter.DateTimeConverter.PATTERN_TYPE": "{1}: '{0}' değerini dönüştürmek için 'pattern' yada 'type' değeri girilmelidir.",
      "javax.faces.converter.NumberConverter.CURRENCY": "{2}: '{0}' değeri parasal birim olarak anlaşılamadı.",
      "javax.faces.converter.NumberConverter.CURRENCY_detail": "{2}: '{0}' değeri parasal birim olarak anlaşılamadı. Örnek: {1}.",
      "javax.faces.converter.NumberConverter.PERCENT": "{2}: '{0}' değeri yüzdesel olarak anlaşılamadı.",
      "javax.faces.converter.NumberConverter.PERCENT_detail": "{2}: '{0}' değeri yüzdesel olarak anlaşılamadı. Örnek: {1}.",
      "javax.faces.converter.NumberConverter.NUMBER": "{2}: '{0}' değeri sayı olarak anlaşılamadı.",
      "javax.faces.converter.NumberConverter.NUMBER_detail": "{2}: '{0}' değeri sayı olarak anlaşılamadı. Örnek: {1}.",
      "javax.faces.converter.NumberConverter.PATTERN": "{2}: '{0}' değeri sayı deseni olarak anlaşılamadı.",
      "javax.faces.converter.NumberConverter.PATTERN_detail": "{2}: '{0}' değeri sayı deseni olarak anlaşılamadı. Örnek: {1}.",
      "javax.faces.validator.LengthValidator.MINIMUM": "{1}: Doğrulama Hatası: Uzunluk, izin verilen minimum değerden daha az: '{0}'.",
      "javax.faces.validator.LengthValidator.MAXIMUM": "{1}: Doğrulama Hatası: Uzunluk izin verilen maksimum değerden daha büyük: '{0}'.",
      "javax.faces.validator.RegexValidator.PATTERN_NOT_SET": "Regex deseni boş olamaz.",
      "javax.faces.validator.RegexValidator.PATTERN_NOT_SET_detail": "Regex deseni boş değer alamaz.",
      "javax.faces.validator.RegexValidator.NOT_MATCHED": "Regex deseni eşleşmedi.",
      "javax.faces.validator.RegexValidator.NOT_MATCHED_detail": "'{0}' ile regex deseni eşleşmedi.",
      "javax.faces.validator.RegexValidator.MATCH_EXCEPTION": "Regex hatası.",
      "javax.faces.validator.RegexValidator.MATCH_EXCEPTION_detail": "Regex hatası, '{0}'.",
      "primefaces.FileValidator.FILE_LIMIT": "Maksimum dosya sayısı aşıldı.",
      "primefaces.FileValidator.FILE_LIMIT_detail": "Maksimum sayı: {0}.",
      "primefaces.FileValidator.ALLOW_TYPES": "Geçersiz dosya türü.",
      "primefaces.FileValidator.ALLOW_TYPES_detail": "Geçersiz dosya türü: '{0}'. İzin verilen türler: '{1}'.",
      "primefaces.FileValidator.SIZE_LIMIT": "Geçersiz dosya boyutu.",
      "primefaces.FileValidator.SIZE_LIMIT_detail": "'{0}' dosyası {1} boyutundan büyük olmamalıdır.",
      //optional for bean validation integration in client side validation
      "javax.faces.validator.BeanValidator.MESSAGE": "{0}",
      "javax.validation.constraints.AssertFalse.message": "yanlış olmalı",
      "javax.validation.constraints.AssertTrue.message": "doğru olmalı",
      "javax.validation.constraints.DecimalMax.message": "{0}&#39;dan küçük veya ona eşit olmalıdır",
      "javax.validation.constraints.DecimalMin.message": "{0}&#39;dan büyük veya ona eşit olmalıdır",
      "javax.validation.constraints.Digits.message": "sayısal değer sınırların dışında (&lt;{0} hane&gt;.&lt;{1} hane&gt; bekleniyor)",
      "javax.validation.constraints.Email.message": "iyi biçimlendirilmiş bir e-posta adresi olmalıdır",
      "javax.validation.constraints.Future.message": "ileri bir tarih olmalı",
      "javax.validation.constraints.FutureOrPresent.message": "şimdiki veya gelecekteki bir tarih olmalıdır",
      "javax.validation.constraints.Max.message": "{0}&#39;dan küçük veya ona eşit olmalıdır",
      "javax.validation.constraints.Min.message": "{0}&#39;dan büyük veya ona eşit olmalıdır",
      "javax.validation.constraints.Negative.message": "0&#39;dan küçük olmalı",
      "javax.validation.constraints.NegativeOrZero.message": "0&#39;dan küçük veya ona eşit olmalıdır",
      "javax.validation.constraints.NotBlank.message": "boş olmamalıdır",
      "javax.validation.constraints.NotEmpty.message": "boş olmamalıdır",
      "javax.validation.constraints.NotNull.message": "boş olmak zorunda değil",
      "javax.validation.constraints.Null.message": "boş olmalı",
      "javax.validation.constraints.Past.message": "geçmiş bir tarih olmalı",
      "javax.validation.constraints.PastOrPresent.message": "Geçmişteki veya şimdiki bir tarih olmalı",
      "javax.validation.constraints.Pattern.message": "&#39;{0}&#39; ile eşleşmelidir",
      "javax.validation.constraints.Positive.message": "0&#39;dan büyük olmalı",
      "javax.validation.constraints.PositiveOrZero.message": "0&#39;dan büyük veya ona eşit olmalıdır",
      "javax.validation.constraints.Size.message": "boyut {0} ile {1} arasında olmalıdır",
    },
  });
}
